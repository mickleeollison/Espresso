angular
		.module('myApp')
		.controller(
				'registerCtrl',
				[
						'$scope',
						'usersFactory',
						function($scope, usersFactory) {

							// Sets variables
							$scope.username;
							$scope.password;
							$scope.user = {};
							$scope.user.userPassword;
							$scope.user.userEmail;
							$scope.confirmUserPassword;

							// Gets the current logged in user Id.
							$scope.getUsers = function() {
								usersFactory.getUsers().then(function(results) {
									$scope.results = results;
								}, function(error) {
									console.log(error);
								});
							};

							// Adds a user to the database upon validation is
							// passed.
							$scope.addUser = function() {
								
								usersFactory
										.addUser($scope.user)
										.then(
												function(results) {
													window.location.href = "http://localhost:8080/login";
												}, function(error) {
													console.log(error);
												});
							};

						} ]);