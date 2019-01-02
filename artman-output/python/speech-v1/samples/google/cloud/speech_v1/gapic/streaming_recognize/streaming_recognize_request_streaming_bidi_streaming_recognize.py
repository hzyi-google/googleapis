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

# DO NOT EDIT! This is a generated sample ("RequestStreamingBidi",  "streaming_recognize")

# To install the latest published package dependency, execute the following:
#   pip install google-cloud-speech

import sys

# [START streaming_recognize]

from google.cloud import speech_v1
import io
import six


def sample_streaming_recognize(audio_content_file_name):
    """Proof of concept for streaming recognize"""

    # [START streaming_recognize_core]

    client = speech_v1.SpeechClient()

    # audio_content_file_name = 'path/to/audio.wav'

    if isinstance(audio_content_file_name, six.binary_type):
        audio_content_file_name = audio_content_file_name.decode('utf-8')
    with io.open(audio_content_file_name, 'rb') as f:
        audio_content = f.read()
    request = {'audio_content': audio_content}

    requests = [request]
    for response_item in client.streaming_recognize(requests):
        for alternative in response_item.results[0].alternatives:
            alt = alternative
            print('alternative: {}'.format(alt))

    # [END streaming_recognize_core]


# [END streaming_recognize]


def main():
    import argparse

    parser = argparse.ArgumentParser()
    parser.add_argument(
        '--audio_content_file_name', type=str, default='path/to/audio.wav')
    args = parser.parse_args()

    sample_streaming_recognize(args.audio_content_file_name)


if __name__ == '__main__':
    main()
