<%@include file="../includes/header.jsp" %>
<%@include file="../includes/navbar.jsp" %>
<script src="../../../static/js/angularTest.js"></script>
<div ng-app = "myApp">
    <div class=col-lg-4 ng-controller = "myCtrl">
        <form>
            <h2 class="text-center">These are our Employees</h2>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>
                            Name
                        </th>
                        <th>
                            Email
                        </th>
                        <th>
                            Position
                        </th>
                        <th>
                            ID
                        </th>
                        <th>
                            Edit
                        </th>
                        <th>
                            Delete
                        </th>
                    </tr>
                </thead>
                <tr data-ng-repeat="employee in employees">
                    <td>
                        {{employee.firstName + " " + employee.lastName}}
                    </td>
                    <td>
                        {{employee.emailAddress}}
                    </td>
                    <td>
                        {{employee.position}}
                    </td>
                    <td>
                        {{employee.id}}
                    </td>
                    <td>
                        <button class="btn btn-primary" type="button" onclick="showUpdateModal()">
                            Edit
                        </button>
                    </td>
                    <td>
                        <button class="btn btn-primary" type="button" onclick="showDeleteModal()">
                            Delete
                        </button>
                    </td>
                </tr>
            </table>
            <label for="empId">Enter An Employee Id</label>
            <input class="form-control" id="empId">
            <br>
            <label for="empEmail">Enter An Employee Email</label>
            <input class="form-control" id="empEmail">
            <br>
            <h3>{{activeEmployee.firstName + " " + activeEmployee.lastName}}</h3>
            <h3>{{status}}</h3>
        </form>
        <div class="modal" id="updateModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">Edit Employee</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form">
                            <input class="form-control" type="hidden" id="employeeId">
                            <input class="form-control" type="hidden" id="employeeVersion">
                            <label class="form-label" for="firstName">First Name</label>
                            <input class="form-control" type="text" id="firstName">
                            <label class="form-label" for="lastName">Last Name</label>
                            <input class="form-control" type="text" id="lastName">
                            <label class="form-label" for="middleName">Middle Name</label>
                            <input class="form-control" type="text" id="middleName">
                            <label class="form-label" for="phoneNumber">Phone Number</label>
                            <input class="form-control" type="text" id="phoneNumber">
                            <label class="form-label" for="emailAddress">Email Address</label>
                            <input class="form-control" type="email" id="emailAddress">
                            <label class="form-label" for="hireDate">Hire Date</label>
                            <input class="form-control" type="date" id="hireDate">
                            <label class="form-label" for="position">Position</label>
                            <input class="form-control" type="text" id="position">
                            <label class="form-label" for="isEmployed">Employed</label>
                            <input class="form-control" type="checkbox" id="isEmployed">
                            <label class="form-label" for="pto">Paid Time Off</label>
                            <input class="form-control" type="textarea" id="pto">
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary" id="updateEmployeeBtn">Update</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="../includes/footer.jsp" %>