// create the module and name it scotchApp
var scotchApp = angular.module('scotchApp', ['ngRoute']);

// configure our routes
scotchApp.config(function($routeProvider) {
	$routeProvider

		// route for the home page
		.when('/', {
			template : '<div class="jumbotron text-center"><h1>Home Page</h1><p>{{ message }}</p><table border="2" width="70%" cellpadding="2"> <tr><th>Id</th><th>Name</th><th>Salary</th><th>Edit</th><th>Delete</th></tr> <tr ng-repeat="emp in details"><td>{{ emp.id }}</td> <td>{{emp.name}}</td> <td>{{emp.salary}}</td><td><a href="update/{{emp.id}}">Update Employee</a></td>  <td><a href="remove/{{emp.id}}">Remove Employee</a></td>  </tr>   </div>',
			controller  : 'mainController'
		})

		// route for the about page
		.when('/about', {
			template : '<div class="jumbotron text-center"><h1>About Page</h1><p>{{ message }}</p></div>',
			controller  : 'aboutController'
		})

		// route for the contact page
		.when('/contact', {
			template : '<div class="jumbotron text-center"><h1>Contact Page</h1><p>{{ message }}</p></div>',
			controller  : 'contactController'
		});
});

// create the controller and inject Angular's $scope
scotchApp.controller('mainController', function($scope, $http) {
	// create a message to display in our view
	$http.get("listjson")
	  .then(function(response){ $scope.details = response.data;console.log($scope.details) });
	$scope.message = 'Everyone come and see how good I look!';
});

scotchApp.controller('aboutController', function($scope) {
	$scope.message = 'Look! I am an about page.';
});

scotchApp.controller('contactController', function($scope) {
	$scope.message = 'Contact us! JK. This is just a demo.';
});