var app=angular.module('myApp' , ['ngRoute']);

app.config(function($routeProvider){
	$routeProvider
	
	
	console.log("inside app ")
	
	.when('/home', {
		templateUrl : 'c_home/home.html',
		controller  : 'HomeController'
	})
	
	
	
	.when('/register', {
		templateUrl : 'c_user/register.html',
		controller  : 'UserController'
	})
	
	.otherwise({redirectTo: '/'});
	
});