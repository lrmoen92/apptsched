<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Autocomplete using Elasticsearch ">
    <title>Elasticsearch Autocomplete</title>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js">
    </script>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <!--
    <script src="elasticsearch-js/elasticsearch.angular.min.js"></script>
    <script src="elasticsearch-js/elasticsearch.jquery.min.js"></script>
    <script src="elasticsearch-js/elasticsearch.min.js"></script>
    -->
</head>
<style type="text/css">
    .container{
        width:90%;
        margin:5em auto;
    }
</style>
<body>
<div class="container">
    <div class="input-group">
        <span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></span>
        <input type="text" class="form-control" placeholder="Search" aria-describedby="basic-addon1" id="search" onfocus="setFocus(1)" onblur="setFocus(0)">
    </div>
    <div id="results"></div>
</div><!-- /container -->
</body>
<script type="text/javascript">
    var focus=0;
    var results='';
    function setFocus(n){
        focus=n;
        getSuggest();
    }
    function getSuggest(){
        var search=$('#search');
        var text=search.val();
//        var feed ='{"suggest" : {"text" : "'+text+'","completion" : {"field" : "suggest","fuzzy" : {"fuzziness" : 2}}}}';
        var feed = '{"product_suggest":{"text":"'+text+'", "completion": {"field" : "tag_suggest"}}}';
//        console.log(feed);
        $.post( "http://localhost:9200/test_index/_suggest", feed, function( data ) {
//            console.log(data['suggest'][0]['options']["0"]['text']);
//            console.log(data);
            var exists = [];
            $.each(data['product_suggest'][0]['options'],
                function(index, value){
                    results+=value.text;
                    results+='<br/>';
                }
            );
            $('#results').html(results);
            results='';
            if (focus==1) setTimeout(function(){getSuggest()}, 300);
        });
    }
</script>
</html>