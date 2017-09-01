<%@include file="../includes/header.jsp" %>
<div ng-app = "myApp">
    <div class=col-lg-4 ng-controller = "myCtrl">
        <form>
            <h2>These are our Employees</h2>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>
                            Name
                        </th>
                        <th>
                            Position
                        </th>
                    </tr>
                </thead>
                <tr data-ng-repeat="employee in employees">
                    <td>
                        {{employee.firstName + " " + employee.lastName}}
                    </td>
                    <td>
                        {{employee.position}}
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>

<script>
    angular.module('myApp', [])
        .controller('myCtrl', function($scope, $http){
            $http({
                method: 'GET',
                url: 'http://localhost:8080/api/employee/'
            }).then(function successCallback(response){
                    $scope.employees = response.data;
                }, function errorCallback(response){
                    $scope.employees = "ERROR";
                }
            )}
        )
</script>

<%@include file="../includes/footer.jsp" %>