angular.module('myApp')
    .controller('QuizController', ['$scope', '$http', '$route', function($scope, $http, $route) {
        
    	$scope.removeQwa = function(questionID) {
    		$http.delete('http://localhost:8080/luigi-quiz-backend/quiz/qwaservice/' + questionID);
    		$route.reload();
    	}
    	
        $http.get('http://localhost:8080/luigi-quiz-backend/quiz/quizsetservice').then(function (text) {
            $scope.Quiz = text.data;
        })
        $scope.currentQuestion = 0;
        $scope.result = 0;
        $scope.currentAnswer = {};
        

        $scope.nextQuestion = function () {
            $scope.currentQuestion++;
            if (isCurrentAnswerCorrect()){
                $scope.result++;
            }
            $scope.currentAnswer = {};
            if ($scope.Quiz.qwaList[$scope.currentQuestion]){
            for (i = 0; i < $scope.Quiz.qwaList[$scope.currentQuestion].answers.length; i++) {
                var id = $scope.Quiz.qwaList[$scope.currentQuestion].answers[i].answerID;
                $scope.currentAnswer[id] = false;
            }}
        }

        var isCurrentAnswerCorrect = function () {
            if ($scope.Quiz.qwaList[$scope.currentQuestion]) {
	            for (i = 0; i < $scope.Quiz.qwaList[$scope.currentQuestion].answers.length; i++) {
	                if ($scope.Quiz.qwaList[$scope.currentQuestion].answers[i].isCorrect !== $scope.currentAnswer[$scope.Quiz.qwaList[$scope.currentQuestion].answers[i].answerID]) {
	                    console.log('hier');
	                    return false;
	                }
	            }
	            return true;
            } 
        }
    }])
    .controller('QwaController', ['$scope', '$http', function($scope, $http) {
        
    	$scope.removeQwa = function(questionID) {
    		$http.delete('http://localhost:8080/luigi-quiz-backend/quiz/qwaservice/' + questionID);
        }
    	
    	$scope.editQwa = function(qwa) {
    		$http.put('http://localhost:8080/luigi-quiz-backend/quiz/qwaservice/' + qwa);
        }
    }]);