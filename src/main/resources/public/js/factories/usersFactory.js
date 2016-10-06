angular.module('myApp').factory('usersFactory', ['$http', function($http){

	return {
	
		// GETS the current user that's logged in.
		getUsers: function(){
			return $http.get('/users');
		},
		
		// POSTS a new user to the database upon creation.
		addUser: function(user){
			return $http.post('/users', user);
		}
	};

}]);