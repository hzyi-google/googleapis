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
 * DO NOT EDIT! This is a generated sample ("LongRunningRequestAsync",  "longrunning_recognize")
 */

// [START longrunning_recognize]
require __DIR__ . '/../../../../vendor/autoload.php';

use Google\Cloud\Speech\V1\SpeechClient;
use Google\Cloud\Speech\V1\RecognitionAudio;
use Google\Cloud\Speech\V1\RecognitionConfig;

function sampleLongRunningRecognize()
{
    // [START longrunning_recognize_core]

    $speechClient = new SpeechClient();

    $config = new RecognitionConfig();
    $fileName = 'path/to/audio.wav';
    $content = file_get_contents($fileName);
    $audio = new RecognitionAudio();
    $audio->setContent($content);

    try {
        // start the operation, keep the operation name, and resume later
        $operationResponse = $speechClient->longRunningRecognize($config, $audio);
        $operationName = $operationResponse->getName();
        // ... do other work
        $newOperationResponse = $speechClient->resumeOperation($operationName, 'longRunningRecognize');
        while (!$newOperationResponse->isDone()) {
            // ... do other work
            $newOperationResponse->reload();
        }
        if ($newOperationResponse->operationSucceeded()) {
          $response = $newOperationResponse->getResult();
          foreach ($response->getResults()[0]->getAlternatives() as $alternative) {
              printf("alternative: %s" . PHP_EOL, print_r($alternative, true));
          }
        } else {
          $error = $newOperationResponse->getError();
          // handleError($error)
        }
    } finally {
        $speechClient->close();
    }

    // [END longrunning_recognize_core]
}
// [END longrunning_recognize]

sampleLongRunningRecognize();