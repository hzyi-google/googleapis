<?php
/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * DO NOT EDIT! This is a generated sample ("RequestStreamingBidi",  "streaming_recognize")
 */

// [START streaming_recognize]
require __DIR__ . '/../../../../vendor/autoload.php';

use Google\Cloud\Speech\V1\SpeechClient;
use Google\Cloud\Speech\V1\StreamingRecognizeRequest;

function sampleStreamingRecognize($audioContentFileName)
{
    // [START streaming_recognize_core]

    $speechClient = new SpeechClient();

    // $audioContentFileName = 'path/to/audio.wav';
    $audioContent = file_get_contents($audioContentFileName);
    $request = new StreamingRecognizeRequest();
    $request->setAudioContent($audioContent);

    try {
        // Write all requests to the server, then read all responses until the
        // stream is complete
        $requests = [$request];
        $stream = $speechClient->streamingRecognize();
        $stream->writeAll($requests);
        foreach ($stream->closeWriteAndReadAll() as $responseItem) {
            foreach ($responseItem->getResults()[0]->getAlternatives() as $alternative) {
                $alt = $alternative;
                printf("alternative: %s" . PHP_EOL, print_r($alt, true));
            }
        }
    } finally {
        $speechClient->close();
    }

    // [END streaming_recognize_core]
}
// [END streaming_recognize]

$opts = [
    'audioContentFileName::',
];

$defaultOptions = [
    'audioContentFileName' => 'path/to/audio.wav',
];

$options = getopt('', $opts);
$options += $defaultOptions;

$audioContentFileName = $options['audioContentFileName'];

sampleStreamingRecognize($audioContentFileName);