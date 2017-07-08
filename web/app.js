// Initialize Firebase
var config = {
  apiKey: "AIzaSyAeO9c2_BnWJoJmckhDu4Ra3BYSzfLhdNQ",
  authDomain: "kshamata-68f54.firebaseapp.com",
  databaseURL: "https://kshamata-68f54.firebaseio.com",
  projectId: "kshamata-68f54",
  storageBucket: "kshamata-68f54.appspot.com",
  messagingSenderId: "813353117552"
};

firebase.initializeApp(config);

// AngularJS
var kshamataApp = angular.module('kshamataApp', ['ngRoute', 'firebase']);

kshamataApp.config(['$routeProvider', function($routeProvider) {
  $routeProvider.
  	when('/home', {
  		templateUrl: 'pages/home.html'
  	}).
    when('/members', {
      templateUrl: 'pages/members.html'
    }).
    when('/women', {
      templateUrl: 'pages/women.html',
      controller: 'WomenController'
    }).
    when('/women/add', {
      templateUrl: 'pages/members/add/women.html',
      controller: 'AddWomanController'
    }).
    when('/members/admins', {
      templateUrl: 'pages/members/admins.html',
      controller: 'AdminController'
    }).
    when('/members/volunteers', {
      templateUrl: 'pages/members/volunteers.html',
      controller: 'VolunteersController'
    }).
    when('/members/add/admin', {
      templateUrl: 'pages/members/add/admin.html',
      controller: 'AddAdminController'
    }).
    when('/members/add/volunteer', {
      templateUrl: 'pages/members/add/volunteer.html',
      controller: 'AddVolunteerController'
    }).
    otherwise({
  		redirectTo: '/home'
  	});
}]);

kshamataApp.controller('WomenController', ["$scope", "$firebaseArray", function($scope, $firebaseArray) {
  var womenRef = firebase.database().ref().child("women");
  $scope.women = $firebaseArray(womenRef);
}]);

kshamataApp.controller('AddWomanController', ["$scope", "$firebaseArray", function($scope, $firebaseArray) {
  var womenRef = firebase.database().ref().child("women");
  $scope.women = $firebaseArray(womenRef);

  $scope.addWoman = function() {
    $scope.woman.personal.dateOfBirth = $scope.woman.personal.dateOfBirth.getTime();
    $scope.woman.initial.supportedFromDate = $scope.woman.initial.supportedFromDate.getTime();
    
    $scope.women.$add($scope.woman);
  };
}]);

kshamataApp.controller('AdminController', ["$scope", "$firebaseArray", function($scope, $firebaseArray) {
  var adminsRef = firebase.database().ref().child("admins");
  $scope.admins = $firebaseArray(adminsRef);
}]);

kshamataApp.controller('AddAdminController', ["$scope", "$firebaseArray", function($scope, $firebaseArray) {
  var adminsRef = firebase.database().ref().child("admins");
  $scope.admins = $firebaseArray(adminsRef);

  $scope.addAdmin = function() {
    $scope.admins.$add($scope.admin);
  };
}]);

kshamataApp.controller('VolunteersController', ["$scope", "$firebaseArray", function($scope, $firebaseArray) {
  var volunteersRef = firebase.database().ref().child("volunteers");
  $scope.volunteers = $firebaseArray(volunteersRef);
}]);

kshamataApp.controller('AddVolunteerController', ["$scope", "$firebaseArray", function($scope, $firebaseArray) {
  var volunteersRef = firebase.database().ref().child("volunteers");
  $scope.volunteers = $firebaseArray(volunteersRef);

  $scope.addVolunteer = function() {
    $scope.volunteers.$add($scope.volunteer);
  };
}]);
