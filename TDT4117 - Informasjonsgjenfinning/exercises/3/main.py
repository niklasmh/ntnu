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


# 2.0 Build a dictionary
import gensim
dictionary = gensim.corpora.Dictionary(paragraphs)

# 2.1 Filter away stopwords
stopwords = "a,able,about,across,after,all,almost,also,am,among,an,and,any,are,as,at,be,because,been,but,by,can,cannot,could,dear,did,do,does,either,else,ever,every,for,from,get,got,had,has,have,he,her,hers,him,his,how,however,i,if,in,into,is,it,its,just,least,let,like,likely,may,me,might,most,must,my,neither,no,nor,not,of,off,often,on,only,or,other,our,own,rather,said,say,says,she,should,since,so,some,than,that,the,their,them,then,there,these,they,this,tis,to,too,twas,us,wants,was,we,were,what,when,where,which,while,who,whom,why,will,with,would,yet,you,your".split(",")
token2id = dictionary.token2id
stop_ids = list(map(lambda s: token2id[s], filter(lambda s: s in token2id, stopwords)))
dictionary.filter_tokens(stop_ids)

# 2.2 Map into Bags-of-Words
corpus = [dictionary.doc2bow(p) for p in paragraphs]

print(corpus[0])
