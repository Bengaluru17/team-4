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
  		templateUrl: 'pages/home.html',
  		controller: 'HomeController'
  	}).
    when('/members', {
      templateUrl: 'pages/members.html'
    }).
    when('/women', {
      templateUrl: 'pages/women.html'
    }).
    when('/members/admins', {
      templateUrl: 'pages/members/admins.html'
    }).
    when('/members/volunteers', {
      templateUrl: 'pages/members/volunteers.html'
    }).
    when('/members/add/admin', {
      templateUrl: 'pages/members/add/admin.html'
    }).
    when('/members/add/volunteer', {
      templateUrl: 'pages/members/add/volunteer.html'
    }).
    otherwise({
  		redirectTo: '/home'
  	});
}]);

kshamataApp.controller('HomeController', function($scope, $firebaseArray) {

});

kshamataApp.controller('AddVolunteerController', ["$scope", "$firebaseArray", function($scope, $firebaseArray) {
  var volunteersRef = firebase.database().ref().child("volunteers");

  $scope.volunteer = $firebaseArray(volunteersRef);

  $scope.addVolunteer = function() {
    $scope.volunteer.$add($scope.newVolunteer);
  };
}]);
