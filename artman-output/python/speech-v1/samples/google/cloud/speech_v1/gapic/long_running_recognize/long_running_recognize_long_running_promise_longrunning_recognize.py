# -*- coding: utf-8 -*-
#
# Copyright 2018 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# DO NOT EDIT! This is a generated sample ("LongRunningPromise",  "longrunning_recognize")

# To install the latest published package dependency, execute the following:
#   pip install google-cloud-speech

import sys

# [START longrunning_recognize]

from google.cloud import speech_v1
import io


def sample_long_running_recognize():
    """Proof of concept for longrunning recognize"""

    # [START longrunning_recognize_core]

    client = speech_v1.SpeechClient()

    # TODO: Initialize `config`:
    config = {}
    file_name = 'path/to/audio.wav'
    with io.open(file_name, 'rb') as f:
        content = f.read()
    audio = {'content': content}

    operation = client.long_running_recognize(config, audio)

    print('Waiting for operation to complete...')
    response = operation.result()

    for alternative in response.results[0].alternatives:
        print('alternative: {}'.format(alternative))

    # [END longrunning_recognize_core]


# [END longrunning_recognize]


def main():
    import argparse

    parser = argparse.ArgumentParser()
    args = parser.parse_args()

    sample_long_running_recognize()


if __name__ == '__main__':
    main()
