

var app = angular.module("manage", []);

//Controller Part
app.controller("ContactController", function($scope, $http) {


	$scope.contacts = [];
	$scope.contactForm = {
			id : -1,
			name : "",
			phone_number : "",
			address : ""
	};


	_refreshcontactData();



	$scope.submitContact = function() {
		var method = "";
		var url = "";
		method = "POST";
		url = 'http://localhost:8080/addContact';

		$http({
			method : method,
			url : url,
			data : angular.toJson($scope.contactForm),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then( _success, _error );

		alert("Operation  completed successfully");
	};



	$scope.showAll = function() {

		_refreshcontactData();

	};

	$scope.updateContact = function() {
		var method = "";
		var url = "";

		method = "POST";
		url = 'http://localhost:8080/updateContact';

		$http({
			method : method,
			url : url,
			data : angular.toJson($scope.contactForm),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {
			$scope.contacts = response.data;
			_refreshcontactData();
			_clearFormData();
		}, function errorCallback(response) {
			alert(JSON.stringify(response));
			console.log(response.statusText);
		});

	};

	
	$scope.submitFilter = function() {
		var method = "";
		var url = "";

		method = "POST";
		url = 'http://localhost:8080/searchContacts';

		$http({
			method : method,
			url : url,
			data : angular.toJson($scope.contactForm),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {
			$scope.contacts = response.data;
		}, function errorCallback(response) {
			alert(JSON.stringify(response));
			console.log(response.statusText);
		});

	};

	
	$scope.sortByName = function() {
		var method = "";
		var url = "";

		method = "GET";
		url = 'http://localhost:8080/sortByName';

		$http({
			method : method,
			url : url,
			data : angular.toJson($scope.contactForm),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(function successCallback(response) {
			$scope.contacts = response.data;
		}, function errorCallback(response) {
			alert(JSON.stringify(response));
			console.log(response.statusText);
		});

	};

	
	//HTTP DELETE- delete contact by Id
	$scope.deleteContact = function(contact) {

		$scope.contactForm.name = contact.name;
		$scope.contactForm.phone_number = contact.phone_number;
		$scope.contactForm.address = contact.address;

		$http({
			method : 'POST',
			url : 'http://localhost:8080/removeContact',
			data : angular.toJson($scope.contactForm),
			headers : {
				'Content-Type' : 'application/json'
			}
		}).then(_success, _error);
	};

	// In case of edit, populate form fields 
	$scope.editContact = function(contact) {

		$scope.contactForm.name = contact.name;
		$scope.contactForm.phone_number = contact.phone_number;
		$scope.contactForm.address = contact.address;
		
		alert("Please edit above and click on Update button. Please don't edit Name..");
	};


	function _refreshcontactData() {
		$http({
			method : 'GET',
			url : 'http://localhost:8080/getAll'
		}).then(function successCallback(response) {
			$scope.contacts = response.data;
		}, function errorCallback(response) {
			alert(JSON.stringify(response));
			console.log(response.statusText);
		});
	}

	function _success(response) {
		_refreshcontactData();
		_clearFormData()
	}

	function _error(response) {
		alert(JSON.stringify(response));
		console.log(response.statusText);
	}

	//Clear the form
	function _clearFormData() {
		$scope.contactForm.id = -1;
		$scope.contactForm.name = "";
		$scope.contactForm.phone_number = "";
		$scope.contactForm.address = "";

	};

});
