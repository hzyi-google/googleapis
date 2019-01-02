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
 * DO NOT EDIT! This is a generated sample ("Request",  "analyze_sentiment")
 */

// [START analyze_sentiment]
require __DIR__ . '/../../../../vendor/autoload.php';

use Google\Cloud\Language\V1\LanguageServiceClient;
use Google\Cloud\Language\V1\Document;
use Google\Cloud\Language\V1\Document_Type;

function sampleAnalyzeSentiment()
{
    // [START analyze_sentiment_core]

    $languageServiceClient = new LanguageServiceClient();

    $type = Document_Type::PLAIN_TEXT;
    $content = 'Your text to analyze, e.g. Hello, world!';
    $document = new Document();
    $document->setType($type);
    $document->setContent($content);

    try {
        $response = $languageServiceClient->analyzeSentiment($document);
        printf("%s" . PHP_EOL, print_r($response, true));
    } finally {
        $languageServiceClient->close();
    }

    // [END analyze_sentiment_core]
}
// [END analyze_sentiment]

sampleAnalyzeSentiment();