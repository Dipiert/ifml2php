<?php

namespace app\controllers\domainModelControllers;
use Yii;
use yii\web\Controller;
use yii\db\Connection; 

class MovieController extends Controller
{

   function actionAddMovie()
   {   
	
   }

   function actionUpdateMovie()
   {   
	
   }

   function actionDeleteMovie()
   {   
	
   }

   function actionViewMainMenuMovie()
   {
        return $this->render('/InteractionFlowModelViews/MainMenuMovie');
   }
   function actionViewAddFormMovie()
   {
        return $this->render('/InteractionFlowModelViews/AddFormMovie');
   }
   function actionViewUpdateFormMovie()
   {
        return $this->render('/InteractionFlowModelViews/UpdateFormMovie');
   }
   function actionViewDeleteFormMovie()
   {
        return $this->render('/InteractionFlowModelViews/DeleteFormMovie');
   }

}