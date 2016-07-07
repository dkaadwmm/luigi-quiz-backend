angular.module('myApp')
	.controller('QuizController', ['$scope', '$http', '$route', 'values', function($scope, $http, $route, values) {
	    
    	$scope.removeQwa = function(questionID) {
    		$http.delete('http://localhost:8080/luigi-quiz-backend/quiz/qwaservice/' + questionID);
    		$route.reload();
    	}
		
		$http.get('http://localhost:8080/luigi-quiz-backend/quiz/quizsetservice/').then(function (text) {
	        $scope.Quiz = text.data;
	        resetCurrentAnswer();
	    })
	    
	    $scope.currentQuestion = 0;
	    $scope.irgendwas = values.result;
	    $scope.nextQuestion = function () {
	        if (isCorrect()) {
	            values.result++
	        }
	        $scope.currentQuestion++;
	        resetCurrentAnswer();
	    };
	
	    var resetCurrentAnswer = function () {
	        $scope.currentAnswer = {};
	        for (i = 0; i < Object.keys($scope.Quiz.qwaList[$scope.currentQuestion].answers).length; i++) {
	            $scope.currentAnswer[$scope.Quiz.qwaList[$scope.currentQuestion].answers[i].answerID] = false;
	        }
	    }
	
	    var isCorrect = function () {
	        console.log($scope.currentAnswer);
	        for (i = 0; i < Object.keys($scope.Quiz.qwaList[$scope.currentQuestion].answers).length; i++) {
	            var answerID = $scope.Quiz.qwaList[$scope.currentQuestion].answers[i].answerID;
	            console.log($scope.currentAnswer[answerID]);
	            console.log($scope.Quiz.qwaList[$scope.currentQuestion].answers[i].isCorrect);
	
	            if ($scope.currentAnswer[answerID] != $scope.Quiz.qwaList[$scope.currentQuestion].answers[i].isCorrect) {
	                return false;
	            }
	        }
	        return true;
	    }
	}])
    .controller('QwaController', ['$scope', '$http', '$route', function($scope, $http, $route) {
        
    	$scope.removeQwa = function(questionID) {
    		$http.delete('http://localhost:8080/luigi-quiz-backend/quiz/qwaservice/' + questionID);
    		$route.reload();
    	}
    	
    	$scope.editQwa = function(qwa) {
    		$http.put('http://localhost:8080/luigi-quiz-backend/quiz/qwaservice/' + qwa);
        }
    }]);