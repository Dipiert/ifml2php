<?php

namespace Movies\Http\Controllers\domainModelControllers;   

use Movies\Http\Controllers\Controller;
use Movies\Http\Requests\domainModelRequests\MovieRequest;
use Movies\domainModelModels\Movie;

class MovieController extends Controller
{

   protected function addMovie(MovieRequest $request)
   {
    $request->merge(['isSaga' => ($request->__isset('saga'))? 1 : 0]);
    $movie = new Movie($request->all());
    $movie->save(); 
    $request->session()->flash('flash_message', 'Se agregó una nueva película exitosamente');
    return redirect()->route("movie.MainMenuMovie");
   }
        

   protected function updateMovie(MovieRequest $request)
   {   
    $request->merge(['isSaga' => ($request->__isset('saga'))? 1 : 0]);
    
    Movie::where('title', $request->get('title'))
           ->update(['title' => $request->get('title'),
                     'year' => $request->get('year'),    
                     'audience' => $request->get('audience'),    
                     'isSaga' => $request->get('isSaga')
                    ]);
    $request->session()->flash('flash_message', 'Se actualizó una película exitosamente');
    return redirect()->route("movie.MainMenuMovie"); 
    }
        

   protected function deleteMovie(MovieRequest $request)
   {   
    Movie::where('title', $request->get('title'))->delete();
    $request->session()->flash('flash_message', 'Se eliminó una película exitosamente');
    return redirect()->route("movie.MainMenuMovie");
   }
        

/**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        dd("index :)");
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        dd("create :)");
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(MovieRequest $request)
    {
        dd("request :)");
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        dd("show :)");
    }


    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        dd("edit :)");
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(MovieRequest $request, $id)
    {
        dd("update :)");
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        dd("destroy :)");
    }

    function createViewMainMenuMovie()
    {
         return view('InteractionFlowModelViews.MainMenuMovie');
    }

    function createViewAddFormMovie()
    {
         return view('InteractionFlowModelViews.AddFormMovie');
    }

    function createViewUpdateFormMovie()
    {
         return view('InteractionFlowModelViews.UpdateFormMovie');
    }

    function createViewDeleteFormMovie()
    {
         return view('InteractionFlowModelViews.DeleteFormMovie');
    }

}