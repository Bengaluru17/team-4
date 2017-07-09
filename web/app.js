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
      templateUrl: 'pages/users/add/women.html',
      controller: 'AddWomanController'
    }).
    when('/woman/:id', {
      templateUrl: 'pages/users/edit/woman.html',
      controller: 'EditWomanController'
    }).
    when('/users/admins', {
      templateUrl: 'pages/users/admins.html',
      controller: 'AdminController'
    }).
    when('/users/volunteers', {
      templateUrl: 'pages/users/volunteers.html',
      controller: 'VolunteersController'
    }).
    when('/users/add/admin', {
      templateUrl: 'pages/users/add/admin.html',
      controller: 'AddAdminController'
    }).
    when('/users/add/volunteer', {
      templateUrl: 'pages/users/add/volunteer.html',
      controller: 'AddVolunteerController'
    }).
    when('/schedule-visits', {
      templateUrl: 'pages/schedule-visits.html',
      controller: 'ScheduleVisitsController'
    }).
    when('/activity-tracking', {
      templateUrl: 'pages/activity-tracking.html',
      controller: 'ActivityTrackingController'
    }).
    when('/activity-tracking/add', {
      templateUrl: 'pages/add-activity-tracking.html',
      controller: 'AddActivityController'
    }).
    when('/reports', {
      templateUrl: 'pages/report.html',
      controller: 'ReportController'
    }).
    otherwise({
  		redirectTo: '/home'
  	});
}]);

kshamataApp.controller('WomenController', function($scope, $firebaseArray) {
  var womenRef = firebase.database().ref().child("women");
  $scope.women = $firebaseArray(womenRef);
});

kshamataApp.controller('EditWomanController', function($scope, $routeParams, $firebaseArray) {
  var womenRef = firebase.database().ref().child("women");
  $scope.women = $firebaseArray(womenRef);

  $scope.women.$loaded().then(function() {
    $scope.woman = $scope.women.$getRecord($routeParams.id);
  });
});

kshamataApp.controller('AddWomanController', function($scope, $location, $firebaseArray) {
  var womenRef = firebase.database().ref().child("women");
  $scope.women = $firebaseArray(womenRef);

  $scope.addWoman = function() {
    $scope.women.$add($scope.woman);
    $location.path('/women');
  };
});

kshamataApp.controller('AdminController', function($scope, $firebaseArray) {
  var adminsRef = firebase.database().ref().child("admins");
  $scope.admins = $firebaseArray(adminsRef);
});

kshamataApp.controller('AddAdminController', function($scope, $location, $firebaseArray) {
  var adminsRef = firebase.database().ref().child("admins");
  $scope.admins = $firebaseArray(adminsRef);

  $scope.addAdmin = function() {
    $scope.admins.$add($scope.admin);
    $location.path('/users/admin');
  };
});

kshamataApp.controller('VolunteersController', function($scope, $firebaseArray) {
  var volunteersRef = firebase.database().ref().child("volunteers");
  $scope.volunteers = $firebaseArray(volunteersRef);
});

kshamataApp.controller('AddVolunteerController', function($scope, $location, $firebaseArray) {
  var volunteersRef = firebase.database().ref().child("volunteers");
  $scope.volunteers = $firebaseArray(volunteersRef);

  $scope.addVolunteer = function() {
    $scope.volunteers.$add($scope.volunteer);
    $location.path('/users/volunteers');
  };
});

kshamataApp.controller('ScheduleVisitsController', function($scope, $firebaseArray) {
  $( "#schedule-visit-form" ).hide();

  var scheduleVisitsRef = firebase.database().ref().child("scheduleVisits");
  $scope.scheduleVisits = $firebaseArray(scheduleVisitsRef);

  var volunteersRef = firebase.database().ref().child("volunteers");
  $scope.volunteers = $firebaseArray(volunteersRef);
  $scope.volunteerSelect = [];

  var womenRef = firebase.database().ref().child("women");
  $scope.women = $firebaseArray(womenRef);
  $scope.womanSelect = [];

  $scope.women.$loaded().then(function() {
    angular.forEach($scope.women, function(woman) {
      $scope.womanSelect.push(woman.fullName);
    });
  });

  $scope.volunteers.$loaded().then(function() {
    angular.forEach($scope.volunteers, function(volunteer) {
      $scope.volunteerSelect.push(volunteer.name);
    });
  });

  $scope.openForm = function() {
    $( "#schedule-visit-form" ).show();
  };

  $scope.hideForm = function() {
    $scope.scheduleVisits.$add($scope.scheduleVisit);
    $( "#schedule-visit-form" ).hide();
  };
});

kshamataApp.controller('ActivityTrackingController', function($scope, $firebaseArray) {
  var activityTrackingRef = firebase.database().ref().child("activityTracking");
  $scope.activities = $firebaseArray(activityTrackingRef);
});

kshamataApp.controller('AddActivityController', function($scope, $location, $firebaseArray) {
  var activityTrackingRef = firebase.database().ref().child("activityTracking");
  $scope.activities = $firebaseArray(activityTrackingRef);

  $scope.addActivity = function() {
    $scope.activities.$add($scope.activity);
    $location.path('/activity-tracking');
  };
});

kshamataApp.controller('ReportController', function($scope, $location, $firebaseArray) {
  var womenRef = firebase.database().ref().child("women");
  $scope.women = $firebaseArray(womenRef);

  var activityTrackingRef = firebase.database().ref().child("activityTracking");
  $scope.activities = $firebaseArray(activityTrackingRef);

  $scope.report1 = [];
  $scope.report2 = [];

  $scope.women.$loaded().then(function() {
    angular.forEach($scope.women, function(woman) {
      console.log(woman);

      if ($(woman.tracking).length > 0) {
        $scope.report1.push({
          name: woman.fullName,
          visits: $(woman.tracking).length
        });
      }
    });
  });

  $scope.activities.$loaded().then(function() {
    angular.forEach($scope.activities, function(activity) {
      $scope.report2.push({
        industry: activity.institution,
        number: activity.numberEngaged
      });
    });
  });

  $scope.report3 = [];

  $scope.report3.push({ name: 'Laskhmi Chinmayi' });
  $scope.report3.push({ name: 'Maria Benz' });
  $scope.report3.push({ name: 'Veena S' });
  $scope.report3.push({ name: 'Seema Devi' });
  $scope.report3.push({ name: 'Padmavathi Devi' });
});
