

    	angular.module('SimplePhonebook', [])
.controller('contactsctrl', function($scope, $http) {	
    $http.get('http://localhost:8080/getFirstSerachByName?name=Oleta Level&v=" + Date.now()).
        then(function(response) {
            $scope.contact = response.data;
			alert($scope.contact.name);
        });
});