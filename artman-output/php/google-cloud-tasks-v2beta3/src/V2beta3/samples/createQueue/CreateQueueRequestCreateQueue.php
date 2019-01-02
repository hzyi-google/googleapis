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
 * DO NOT EDIT! This is a generated sample ("Request",  "create_queue")
 */

// [START create_queue]
require __DIR__ . '/../../../../vendor/autoload.php';

use Google\Cloud\Tasks\V2beta3\CloudTasksClient;
use Google\Cloud\Tasks\V2beta3\Queue;

function sampleCreateQueue($locationOfTheQueue, $locationId)
{
    // [START create_queue_core]

    $cloudTasksClient = new CloudTasksClient();

    // $locationOfTheQueue = ' my_location';
    // $locationId = ' my_location';
    $formattedParent = $cloudTasksClient->locationName( "my_project_name", $locationId);
    $formattedName = $cloudTasksClient->queueName( my_project, $locationOfTheQueue,  my_queue);
    $queue = new Queue();
    $queue->setName($formattedName);

    try {
        $response = $cloudTasksClient->createQueue($formattedParent, $queue);
        printf("%s" . PHP_EOL, print_r($response, true));
    } finally {
        $cloudTasksClient->close();
    }

    // [END create_queue_core]
}
// [END create_queue]

$opts = [
    'locationOfTheQueue::',
    'locationId::',
];

$defaultOptions = [
    'locationOfTheQueue' => ' my_location',
    'locationId' => ' my_location',
];

$options = getopt('', $opts);
$options += $defaultOptions;

$locationOfTheQueue = $options['locationOfTheQueue'];
$locationId = $options['locationId'];

sampleCreateQueue($locationOfTheQueue, $locationId);