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
  	when('/woman', {
  		templateUrl: 'woman-select.html',
      controller: 'WomanSelectController'
  	}).
    when('/woman/:id', {
      templateUrl: 'new-tracking.html',
      controller: 'NewTrackingController'
    }).
    otherwise({
  		redirectTo: '/woman'
  	});
}]);

kshamataApp.controller('WomanSelectController', function($scope, $firebaseArray) {
  var womenRef = firebase.database().ref().child("women");
  $scope.women = $firebaseArray(womenRef);
});

kshamataApp.controller('NewTrackingController', function($scope, $routeParams, $firebaseArray) {
  var womenRef = firebase.database().ref().child("women");
  $scope.women = $firebaseArray(womenRef);

  $scope.women.$loaded().then(function() {
    $scope.woman = $scope.women.$getRecord($routeParams.id);
  });

  $scope.addTracking = function() {
    $scope.tracking.timestamp = firebase.database['ServerValue']['TIMESTAMP'];

    var item = $scope.women.$getRecord($routeParams.id);
    item.tracking = $scope.tracking;

    var tracking = new $firebaseArray(womenRef.child($routeParams.id+'/tracking'));
    tracking.$add($scope.tracking);
  };
});
