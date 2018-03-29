var urls = getLaravelURLs();
processPages();

function getLaravelURLs() {
	var home = 'http://localhost/laravel5.4.15/public/'
	var routes = ['movie/MainMenuMovie',
		'movie/AddFormMovie',
		'movie/UpdateFormMovie',
		'movie/DeleteFormMovie',
		'movie',
		'movie/addMovie',
		'movie/updateMovie',
		'movie/deleteMovie'];
	return routes.map(function(r) {
		return home + r;
	});
}

function processPages() {
	if (urls.length == 0) {
		phantom.exit();
	} else {
		url = urls.shift();
		console.log("Loading " + url);
		t = Date.now();
		page = require('webpage').create();
		page.open(url, onFinishedLoading);		
	}
}

function onFinishedLoading(status) {
	t = Date.now() - t;
	console.log(status);
	console.log('Loading time ' + t + ' msec\n');
	page.release();
	processPages();
}