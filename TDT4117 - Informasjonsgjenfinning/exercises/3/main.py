#!/usr/bin/python3

# 1.0 Create a random sequence
import random
random.seed(123)

# 1.1 Read file
import codecs
f = codecs.open("pg3300.txt", "r", "utf-8")

# 1.2 Split into paragraphs
paragraphs = list(filter(lambda p: len(p) != 0, f.read().split('\r\n\r\n')))
paragraphs = list(map(lambda p: p.strip("\r\n"), paragraphs))
paragraphs = list(map(lambda p: " ".join(p.split("\r\n")), paragraphs))

# 1.3 Remove paragraphs with Gutenberg
paragraphs = list(filter(lambda p: "Gutenberg" not in p, paragraphs))
original_paragraphs = paragraphs[:] # Save the paragraphs before modifying them

# 1.4 Tokenize
paragraphs = list(map(lambda p: p.split(" "), paragraphs))

# 1.5 Remove punctuation
import string
paragraphs = list(map(lambda p: list(map(lambda w: w.strip(string.punctuation).lower(), p)), paragraphs))
paragraphs = list(map(lambda p: list(filter(lambda w: len(w) != 0, p)), paragraphs))

# 1.6 Stem words
from nltk.stem.porter import PorterStemmer
stemmer = PorterStemmer()
#paragraphs = list(map(lambda p: list(map(lambda w: stemmer.stem(w), p)), paragraphs)) # Bottleneck

print(paragraphs[0:10])
