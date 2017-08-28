class MovieController extends Controller
{

   protected function addMovie(MovieRequest $request)
   {   
      $imploded = ['Director' => implode($request->get('Director'), ', ')];
      $request->merge($imploded);
      $movie = new Movie($request->all());
      $movie->save();      
   }

   protected function updateMovie(MovieRequest $request)
   {   
       $imploded = ['Director' => implode($request->get('Director'), ', ')];
       $request->merge($imploded);
       $id = $request->get('id');
       $movie = Movie::find($id);    
       $movie->fill($request);
       $movie->save();
   }  
		

   protected function deleteMovie(MovieRequest $request)
   {   
       $id = $request->input('id');
       $movie = Movie::find($id);
       $movie->delete();
   }

}