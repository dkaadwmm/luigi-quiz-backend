angular.module('myApp', ['ngRoute'])
    .config(function($routeProvider) {
        $routeProvider
            .when('/home', {
                templateUrl: './home.html', controller: 'QuizController'
            })
            .when('/quiz', {
                templateUrl: './quiz.html', controller: 'QuizController'
            })
            .when('/result', {
                templateUrl: './result.html', controller: 'QuizController'
            })
            .when('/allquestions', {
                templateUrl: './allquestions.html', controller: 'QuizController'
            })
            .otherwise('/home')})
            .when('/edit', {
             templateUrl: './edit.html', controller: 'QuizController'
             })
                        .otherwise('/home')})
    .run(['$rootScope', '$location', function($rootScope, $location){
        var path = function() {
            return $location.path();};

        $rootScope.$watch(path, function(newVal, oldVal){
            $rootScope.activeMenu = newVal;
        });

    }]);