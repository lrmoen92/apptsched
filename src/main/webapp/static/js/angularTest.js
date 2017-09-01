function showUpdateModal(){
    $('#updateModal').modal('show');
}

function showDeleteModal(){
    $('#deleteModal').modal('show');
}

var angMod = angular.module('myApp', []);

angMod.service('ajaxService', function($http){
    var urlBase = "/api/employee/";
    this.getEmployees = function() {return $http.get(urlBase)};
    this.getEmployee = function(id) {return $http.get(urlBase + id)};
    this.getEmployeeByEmail = function(email) {return $http.get(urlBase + '?email=' + email)};
    this.insertEmployee = function(emp) {return $http.put(urlBase, emp)};
    this.updateEmployee = function(emp) {return $http.put(urlBase + emp.id, emp)};
    this.deleteEmployee = function(id) {return $http.delete(urlBase + id)};
});

angMod.controller('myCtrl', function($scope, ajaxService){

    ajaxService.getEmployees().then(function (response){
        $scope.employees = response.data;
    });

    function getEmployee(id) {
        ajaxService.getEmployee(id).then(function (response) {
            $scope.activeEmployee = response.data;
        }, function (error) {
            $scope.status = error.message;
        })
    }

    function getEmployeeByEmail(email){
        ajaxService.getEmployeeByEmail(email).then(function (response){
            $scope.activeEmployee = response.data;
        }, function (error){
            $scope.status = error.message;
        })
    }

    function insertEmployee(emp){
        ajaxService.insertEmployee(emp).then(function (response){
            //$scope insert?
        }, function (error){
            $scope.status = error.message;
        })
    }

    function updateEmployee(emp){
        ajaxService.updateEmployee(emp).then(function (response){
            //$scope update?
        }, function (error){
            $scope.status = error.message;
        })
    }

    function deleteEmployee(id){
        ajaxService.deleteEmployee(id).then(function (response){
            //$scope delete?
        }, function (error){
            $scope.status = error.message;
        })
    }

    $(document).ready(function(){
        $('#empId').change(function(){
            getEmployee($('#empId').val());
        });
    });

    $(document).ready(function(){
        $('#empEmail').change(function () {
            getEmployeeByEmail($('#empEmail').val());
        });
    });

    $(document).ready(function(){
        $('#updateEmployeeBtn').click(function () {
            var employee = {
                id: $('#employeeId'),
                version: $('#employeeVersion'),
                firstName: $('#firstName'),
                lastName: $('#lastName'),
                middleName: $('#middleName'),
                phoneNumber: $('#phoneNumber'),
                emailAddress: $('#emailAddress'),
                hireDate: $('#hireDate'),
                position: $('#position'),
                isEmployed: $('#isEmployed'),
                pto: $('#pto')
            };
            console.log(employee);
            //updateEmployee(employee)
        });
    });
});