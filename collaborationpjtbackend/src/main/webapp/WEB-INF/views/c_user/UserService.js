'use strict';

app.factory('UserService',['$http', '$q', '$rootScope', function($http,$q,$rootScope){
	
	
	var BASE_URL='http://localhost:8080/collaborationpjtbackend'
		return{
		
		 fetchAllUsers: function() {
	        
	        return $http.get(BASE_URL+'/allusers')
	            .then(
	            function (response) {
	                return response.data;
	            },
	            function(errResponse){
	                console.error('Error while fetching Users');
	                return $q.reject(errResponse);
	            }
	        );
	        
	    },

	    createUser: function() {
	        
	        return $http.post(BASE_URL+'/saveuser/',user)
	            .then(
	            function (response) {
	                return response.data;
	            },
	            function(errResponse){
	                console.error('Error while fetching Users');
	                return $q.reject(errResponse);
	            }
	        );
	        
	    },


	    updateUser: function(user, id) {
	        
	        return $http.put(BASE_URL+'/user/',id, user)
	            .then(
	            function (response) {
	                return response.data;
	            },
	            function(errResponse){
	                console.error('Error while updating User');
	                return $q.reject(errResponse);
	            }
	        );
	        
	    },

	   /* deleteUser: function(id) {
	        
	        return $http.delete(BASE_URL+'/user/'+id)
	            .then(
	            function(response) {
	                return response.data;
	            },
	            function(errResponse){
	                console.error('Error while deleting User');
	                return $q.reject(errResponse);
	            }
	        );
	        
	    
		}*/
	
	}
	
	
}]);

