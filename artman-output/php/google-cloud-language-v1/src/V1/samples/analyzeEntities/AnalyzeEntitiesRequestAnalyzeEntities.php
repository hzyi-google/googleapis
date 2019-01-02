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
 * DO NOT EDIT! This is a generated sample ("Request",  "analyze_entities")
 */

// [START analyze_entities]
require __DIR__ . '/../../../../vendor/autoload.php';

use Google\Cloud\Language\V1\LanguageServiceClient;
use Google\Cloud\Language\V1\Document;
use Google\Cloud\Language\V1\Document_Type;
use Google\Cloud\Language\V1\EncodingType;

function sampleAnalyzeEntities()
{
    // [START analyze_entities_core]

    $languageServiceClient = new LanguageServiceClient();

    $type = Document_Type::PLAIN_TEXT;
    $content = 'Your text to analyze, e.g. Hello, world!';
    $document = new Document();
    $document->setType($type);
    $document->setContent($content);
    $encodingType = EncodingType::NONE;

    try {
        $response = $languageServiceClient->analyzeEntities($document, ['encodingType' => $encodingType]);
        foreach ($response->getEntities() as $entity) {
            printf("entity: %s" . PHP_EOL, print_r($entity, true));
        }
        $lang = $response->getLanguage();
        printf("language in the response: %s" . PHP_EOL, $lang);
    } finally {
        $languageServiceClient->close();
    }

    // [END analyze_entities_core]
}
// [END analyze_entities]

sampleAnalyzeEntities();