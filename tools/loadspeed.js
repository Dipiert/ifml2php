var urls = getLaravelURLs();
Array.prototype.push.apply(urls, getYiiURLs());
processPages();


function getLaravelURLs() {
    var home = 'http://localhost/laravel5.4.15/public/'
    var routes = ['movie/MainMenuMovie',
        'movie/AddFormMovie',
        'movie/UpdateFormMovie',
        'movie/DeleteFormMovie',
    ];
    return makeURL(home, routes);
}

function getYiiURLs() {
    var home = 'http://localhost/yii2.0.12/web/index.php?r=movie/';
    var routes = ['view-main-menu-movie',
    	'view-add-form-movie',
    	'view-update-form-movie',
    	'view-delete-form-movie',
    	];
    return makeURL(home, routes);
}

function makeURL(home, routes) {
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
