angular.module('myApp')
    .controller('QuizController', ['$scope', '$http', function($scope, $http){
        
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
            if ($scope.Quiz.qwaList[$scope.currentQuestion]){
            for (i = 0; i < $scope.Quiz.qwaList[$scope.currentQuestion].answers.length; i++) {
                if ($scope.Quiz.qwaList[$scope.currentQuestion].answers[i].isCorrect !== $scope.currentAnswer[$scope.Quiz.qwaList[$scope.currentQuestion].answers[i].answerID]) {
                    console.log('hier');
                    return false;
                }
            }
            return true;} 
            
        }

    }]);