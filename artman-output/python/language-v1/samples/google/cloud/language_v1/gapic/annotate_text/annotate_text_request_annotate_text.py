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

# DO NOT EDIT! This is a generated sample ("Request",  "annotate_text")

# To install the latest published package dependency, execute the following:
#   pip install google-cloud-language

import sys

# [START annotate_text]

from google.cloud import language_v1
from google.cloud.language_v1 import enums


def sample_annotate_text(should_extract_syntax_info, extract_entities):
    """Proof of concept for annotating texts"""

    # [START annotate_text_core]

    client = language_v1.LanguageServiceClient()

    # should_extract_syntax_info = True
    # extract_entities = True

    type_ = enums.Document.Type.PLAIN_TEXT
    content = 'Your text to analyze, e.g. Hello, world!'
    document = {'type': type_, 'content': content}
    features = {
        'extract_syntax': should_extract_syntax_info,
        'extract_entities': extract_entities
    }
    encoding_type = enums.EncodingType.NONE

    response = client.annotate_text(
        document, features, encoding_type=encoding_type)
    for entity in response.entities:
        print('entity: {}'.format(entity))
    lang = response.language
    print('language in the response: {}'.format(lang))

    # [END annotate_text_core]


# [END annotate_text]


def main():
    import argparse

    parser = argparse.ArgumentParser()
    parser.add_argument(
        '--should_extract_syntax_info', type=bool, default=True)
    parser.add_argument('--extract_entities', type=bool, default=True)
    args = parser.parse_args()

    sample_annotate_text(args.should_extract_syntax_info,
                         args.extract_entities)


if __name__ == '__main__':
    main()
