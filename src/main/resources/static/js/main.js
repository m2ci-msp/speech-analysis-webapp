'use strict';

/* Mary global information */
var mary_host = "localhost";
var mary_port = "59125";

var current_voice = 0;
var current_language = 0;
var current_region = 0;

var wavesurfer_comp;  // Wavesurfer instance
var wavesurfer_ref;  // Wavesurfer instance
var blob_wav;    // Wav buffer
var list_phones; // Phone list for the segmentation part

/********************************************************************************************
 *** Global initialisation functions
 ********************************************************************************************/
function initialisation()
{
    // Create an instance
    wavesurfer_comp = Object.create(WaveSurfer);

    // Init & load audio file
    var options = {
        container     : document.querySelector('#waveform_comp'),
        // FIXME: see for the scrollbar
        // fillParent    : false,
        // minPxPerSec   : 2000,
        waveColor     : '#587d9d',
        progressColor : '#97c7de',
        height:200,
        cursorColor   : 'red'
    };

    if (location.search.match('scroll')) {
        options.minPxPerSec = 100;
        options.scrollParent = true;
    }

    // Init
    wavesurfer_comp.init(options);
    wavesurfer_comp.initRegions();


    // Play at once when ready
    // Won't work on iOS until you touch the page
    wavesurfer_comp.on('ready', function () {
        // Add segmentation labels
        var segmentation = Object.create(WaveSurfer.Segmentation);
        segmentation.init({
            wavesurfer: wavesurfer_comp,
            container: "#timeline_comp"
        });

        // Add segmentation region
        var start = 0;
        wavesurfer_comp.clearRegions();
        for (var p in list_phones) {
            var region = new Object();
            region.start = start;
            region.drag = false;
            region.end = start + (list_phones[p].duration / 1000);
            region.color = randomColor(0.1);
            wavesurfer_comp.addRegion(region);
            start += (list_phones[p].duration / 1000);
        }

        // Add spectrogramm
        var spectrogram = Object.create(WaveSurfer.Spectrogram);

        spectrogram.init({
            wavesurfer: wavesurfer_comp,
            container: "#spectrogram_comp",
            fftSamples: 1024
        });

    });

    // Report errors
    wavesurfer_comp.on('error', function (err) {
        console.error(err);
    });

    // Do something when the clip is over
    wavesurfer_comp.on('finish', function () {
        console.log('Finished playing');
    });


    /* Progress bar */
    document.addEventListener('DOMContentLoaded', function () {
        var progressDiv = document.querySelector('#progress-bar');
        var progressBar = progressDiv.querySelector('.progress-bar');

        var showProgress = function (percent) {
            progressDiv.style.display = 'block';
            progressBar.style.width = percent + '%';
        };

        var hideProgress = function () {
            progressDiv.style.display = 'none';
        };

        wavesurfer_comp.on('loading', showProgress);
        wavesurfer_comp.on('ready', hideProgress);
        wavesurfer_comp.on('destroy', hideProgress);
        wavesurfer_comp.on('error', hideProgress);
    });

    wavesurfer_comp.load("./CA_BB_01_001.wav");


    // Create an instance
    wavesurfer_ref = Object.create(WaveSurfer);

    // Init & load audio file
    var options = {
        container     : document.querySelector('#waveform_ref'),
        // FIXME: see for the scrollbar
        // fillParent    : false,
        // minPxPerSec   : 2000,
        waveColor     : '#587d9d',
        progressColor : '#97c7de',
        height:200,
        cursorColor   : 'red'
    };

    if (location.search.match('scroll')) {
        options.minPxPerSec = 100;
        options.scrollParent = true;
    }

    // Init
    wavesurfer_ref.init(options);
    wavesurfer_ref.initRegions();


    // Play at once when ready
    // Won't work on iOS until you touch the page
    wavesurfer_ref.on('ready', function () {
        // Add segmentation labels
        var segmentation = Object.create(WaveSurfer.Segmentation);
        segmentation.init({
            wavesurfer: wavesurfer_ref,
            container: "#timeline_ref"
        });

        // Add segmentation region
        var start = 0;
        wavesurfer_ref.clearRegions();
        for (var p in list_phones) {
            var region = new Object();
            region.start = start;
            region.drag = false;
            region.end = start + (list_phones[p].duration / 1000);
            region.color = randomColor(0.1);
            wavesurfer_ref.addRegion(region);
            start += (list_phones[p].duration / 1000);
        }

        // Add spectrogramm
        var spectrogram = Object.create(WaveSurfer.Spectrogram);

        spectrogram.init({
            wavesurfer: wavesurfer_ref,
            container: "#spectrogram_ref",
            fftSamples: 1024
        });

    });

    // Report errors
    wavesurfer_ref.on('error', function (err) {
        console.error(err);
    });

    // Do something when the clip is over
    wavesurfer_ref.on('finish', function () {
        console.log('Finished playing');
    });


    /* Progress bar */
    document.addEventListener('DOMContentLoaded', function () {
        var progressDiv = document.querySelector('#progress-bar');
        var progressBar = progressDiv.querySelector('.progress-bar');

        var showProgress = function (percent) {
            progressDiv.style.display = 'block';
            progressBar.style.width = percent + '%';
        };

        var hideProgress = function () {
            progressDiv.style.display = 'none';
        };

        wavesurfer_ref.on('loading', showProgress);
        wavesurfer_ref.on('ready', hideProgress);
        wavesurfer_ref.on('destroy', hideProgress);
        wavesurfer_ref.on('error', hideProgress);
    });

    wavesurfer_ref.load("./CA_BB_01_001.wav");
}



/**
 * Random RGBA color.
 */
function randomColor(alpha) {
    return 'rgba(' + [
        ~~(Math.random() * 255),
        ~~(Math.random() * 255),
        ~~(Math.random() * 255),
        alpha || 1
    ] + ')';
}
