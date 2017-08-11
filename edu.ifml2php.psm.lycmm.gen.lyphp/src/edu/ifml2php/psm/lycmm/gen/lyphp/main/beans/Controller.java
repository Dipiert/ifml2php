package edu.ifml2php.psm.lycmm.gen.lyphp.main.beans;

public class Controller {
	private boolean isHookeable;

	public Controller() {
	   //Las clase Java que proveen servicios a Acceleo deben tener un contructor vacio.
	}
	
	public Controller(boolean isHookeable){
		this.isHookeable = isHookeable;
	}
	
	public boolean isHookeable() {
		return isHookeable;
	}

	public void setHookeable(boolean isHookeable) {
		this.isHookeable = isHookeable;
	}
	
	public String getControllerBoilerplate(){
	   return "/**\r\n     * Display a listing of the resource.\r\n     *\r\n     * @return \\Illuminate\\Http\\Response\r\n     */\r\n    public function index()\r\n    {\r\n        //\r\n    }\r\n\r\n    /**\r\n     * Show the form for creating a new resource.\r\n     *\r\n     * @return \\Illuminate\\Http\\Response\r\n     */\r\n    public function create()\r\n    {\r\n        //\r\n    }\r\n\r\n    /**\r\n     * Store a newly created resource in storage.\r\n     *\r\n     * @param  \\Illuminate\\Http\\Request  $request\r\n     * @return \\Illuminate\\Http\\Response\r\n     */\r\n    public function store(Request $request)\r\n    {\r\n        //\r\n    }\r\n\r\n    /**\r\n     * Display the specified resource.\r\n     *\r\n     * @param  int  $id\r\n     * @return \\Illuminate\\Http\\Response\r\n     */\r\n    public function show($id)\r\n    {\r\n        //\r\n    }\r\n\r\n    /**\r\n     * Show the form for editing the specified resource.\r\n     *\r\n     * @param  int  $id\r\n     * @return \\Illuminate\\Http\\Response\r\n     */\r\n    public function edit($id)\r\n    {\r\n        //\r\n    }\r\n\r\n    /**\r\n     * Update the specified resource in storage.\r\n     *\r\n     * @param  \\Illuminate\\Http\\Request  $request\r\n     * @param  int  $id\r\n     * @return \\Illuminate\\Http\\Response\r\n     */\r\n    public function update(Request $request, $id)\r\n    {\r\n        //\r\n    }\r\n\r\n    /**\r\n     * Remove the specified resource from storage.\r\n     *\r\n     * @param  int  $id\r\n     * @return \\Illuminate\\Http\\Response\r\n     */\r\n    public function destroy($id)\r\n    {\r\n        //\r\n    }";
	}
	
	
}
