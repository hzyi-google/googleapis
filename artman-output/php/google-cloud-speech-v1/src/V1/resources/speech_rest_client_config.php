<?php

return [
    'interfaces' => [
        'google.cloud.speech.v1.Speech' => [
            'Recognize' => [
                'method' => 'post',
                'uriTemplate' => '/v1/speech:recognize',
                'body' => '*',
            ],
            'LongRunningRecognize' => [
                'method' => 'post',
                'uriTemplate' => '/v1/speech:longrunningrecognize',
                'body' => '*',
            ],
        ],
        'google.longrunning.Operations' => [
            'GetOperation' => [
                'method' => 'get',
                'uriTemplate' => '/v1/operations/{name=*}',
                'additionalBindings' => [
                    [
                        'method' => 'get',
                        'uriTemplate' => '/v1beta1/operations/{name=*}',
                    ],
                    [
                        'method' => 'get',
                        'uriTemplate' => '/v1p1beta1/operations/{name=*}',
                    ],
                ],
                'placeholders' => [
                    'name' => [
                        'getters' => [
                            'getName',
                        ],
                    ],
                ]
            ],
        ],
    ]
];
