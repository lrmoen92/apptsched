
var angMod = angular.module('myApp', []);

angMod.service('ajaxService', function($http){
    var urlBase = "/api/employee/";
    this.getEmployees = function() {return $http.get(urlBase)};
    this.getEmployee = function(id) {return $http.get(urlBase + id)};
    this.getEmployeeByEmail = function(email) {return $http.get(urlBase + '?email=' + email)};
    this.insertEmployee = function(emp) {return $http.put(urlBase, emp)};
    this.deleteEmployee = function(id) {return $http.delete(urlBase + id)};
});

angMod.controller('myCtrl', function($scope, ajaxService){

    ajaxService.getEmployees().then(function (response){
        $scope.employees = response.data;
    });

    $scope.showNewEmployeeModal = function showNewEmployeeModal(){
        $('#employeeId').val("");
        $('#employeeVersion').val("");
        $('#firstName').val("");
        $('#lastName').val("");
        $('#middleName').val("");
        $('#phoneNumber').val("");
        $('#emailAddress').val("");
        $('#hireDate').val("");
        $('#position').val("");
        $('#isEmployed').val("");
        $('#pto').val("");
        $('#updateModal').modal('show');
    };


    $scope.showUpdateModal = function showUpdateModal(employee){
        $('#employeeId').val(employee.id);
        $('#employeeVersion').val(employee.version);
        $('#firstName').val(employee.firstName);
        $('#lastName').val(employee.lastName);
        $('#middleName').val(employee.middleName);
        $('#phoneNumber').val(employee.phoneNumber);
        $('#emailAddress').val(employee.emailAddress);
        $('#hireDate').val(employee.hireDate);
        $('#position').val(employee.position);
        $('#isEmployed').val(employee.isEmployed);
        $('#pto').val(employee.pto);
        $('#updateModal').modal('show');
    };

    $scope.showDeleteModal = function showDeleteModal(employee){
        $('#deleteId').val(employee.id);
        $('#deleteModal').modal('show');
    };

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
        });
        window.location.reload();
    }

    function deleteEmployee(id){
        ajaxService.deleteEmployee(id).then(function (response){
            //$scope delete?
        }, function (error){
            $scope.status = error.message;
        });
        window.location.reload();
    }

    $(document).ready(function(){
        $('#empId').change(function(){
            getEmployee($('#empId').val());
        });


        $('#empEmail').change(function () {
            getEmployeeByEmail($('#empEmail').val());
        });


        $('#updateEmployeeBtn').click(function () {
            var employee = {
                id: $('#employeeId').val(),
                version: $('#employeeVersion').val(),
                firstName: $('#firstName').val(),
                lastName: $('#lastName').val(),
                middleName: $('#middleName').val(),
                phoneNumber: $('#phoneNumber').val(),
                emailAddress: $('#emailAddress').val(),
                hireDate: $('#hireDate').val(),
                position: $('#position').val(),
                isEmployed: $('#isEmployed').val(),
                pto: [
                    $('#pto').val()
                ]
            };
            console.log(employee);
            var string = JSON.stringify(employee);
            insertEmployee(string);
        });


        $('#deleteEmployeeBtn').click(function(){
            deleteEmployee($('#deleteId').val());
        });

    });


});