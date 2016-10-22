'use strict';

app.controller('UserController', ['$scope', 'UserService','$location','$rootScope',
             function($scope, UserService,$location,$rootScope) {
	var self = this;
    self.user={
    		user_id:'',
    		fname:'',
    		mname:'',
    		lname:'',
    		dob:'',
    		address:'',
    		contact:'',
    		createddate:'',
    		user_role:'',
    		errorMessage:''};
    self.users=[];
    	
     self.fetchAllUsers = function(){
        UserService.fetchAllUsers()
            .then(
            function(d) {
                self.users = d;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    };

     self.createUser = function(user){
        UserService.createUser(user)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while creating User');
            }
        );
    };

     self.updateUser = function(user, id){
        UserService.updateUser(user, id)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while updating User');
            }
        );
    };
    self.authenticate = function(user){
         UserService.authenticate(user)
             .then(
            		 function(d) {
                         self.users = d;
                         if($rootScope.currentUser)
                        	 {
                        	 	$location.path('/');
                        	 	
                        	 }
                     },
                     
             function(errResponse){
                 console.error('Error while authenticate User');
             }
         );
     };
     
     

     self.deleteUser = function(id){
        UserService.deleteUser(id)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while deleting User');
            }
        );
    };

    self.fetchAllUsers();
    
    self.login = function(){
    	{
    		self.authenticate(self.user);
    	}
    	
    };
     self.submit = function() {
     {
            console.log('Saving New User', self.user);
            createUser(self.user);
     }
      self.reset();
    };

     self.edit = function(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.users.length; i++){
            if(self.users[i].user_id === id) {
                self.user = angular.copy(self.users[i]);
                break;
            }
        }
    };

     self.remove = function(id){
        console.log('id to be deleted', id);
        if(self.user.user_id === id) {//clean form if the user to be deleted is shown there.
            self.reset();
        }
        deleteUser(id);
    }


    function reset(){
        self.user={
        		user_id:'',
        		fname:'',
        		mname:'',
        		lname:'',
        		dob:'',
        		address:'',
        		contact:'',
        		createddate:'',
        		user_role:'',
        		errorMessage:''};
        $scope.myForm.$setPristine(); //reset Form
    }
}]);