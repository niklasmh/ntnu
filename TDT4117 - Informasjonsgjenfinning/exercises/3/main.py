#!/usr/bin/python3

'''
Collaboarated with Petter T. Bemelmans
'''

# 1.0 Create a random sequence
import random
random.seed(123)

# 1.1 Read file
import codecs
f = codecs.open("pg3300.txt", "r", "utf-8")

# 1.2 Split into paragraphs
paragraphs = list(filter(lambda p: len(p) != 0, f.read().split('\r\n\r\n')))
paragraphs = list(map(lambda p: p.strip("\r\n"), paragraphs))

# 1.3 Remove paragraphs with Gutenberg
paragraphs = list(filter(lambda p: "Gutenberg" not in p, paragraphs))
original_paragraphs = paragraphs[:] # Save the paragraphs before modifying them
paragraphs = list(map(lambda p: " ".join(p.split("\r\n")), paragraphs))

# 1.4 Tokenize
paragraphs = list(map(lambda p: p.split(), paragraphs))

# 1.5 Remove punctuation
import string
paragraphs = list(map(lambda p: list(map(lambda w: w.strip(string.punctuation).lower(), p)), paragraphs))
paragraphs = list(map(lambda p: list(filter(lambda w: len(w) != 0, p)), paragraphs))

# 1.6 Stem words
from nltk.stem.porter import PorterStemmer
stemmer = PorterStemmer()
paragraphs = list(map(lambda p: list(map(lambda w: stemmer.stem(w), p)), paragraphs)) # Bottleneck


# 2.0 Build a dictionary
import gensim
dictionary = gensim.corpora.Dictionary(paragraphs)

# 2.1 Filter away stopwords
stopwords = "a,able,about,across,after,all,almost,also,am,among,an,and,any,are,as,at,be,because,been,but,by,can,cannot,could,dear,did,do,does,either,else,ever,every,for,from,get,got,had,has,have,he,her,hers,him,his,how,however,i,if,in,into,is,it,its,just,least,let,like,likely,may,me,might,most,must,my,neither,no,nor,not,of,off,often,on,only,or,other,our,own,rather,said,say,says,she,should,since,so,some,than,that,the,their,them,then,there,these,they,this,tis,to,too,twas,us,wants,was,we,were,what,when,where,which,while,who,whom,why,will,with,would,yet,you,your".split(",")
token2id = dictionary.token2id
stop_ids = [token2id[s] for s in stopwords if s in token2id]
dictionary.filter_tokens(stop_ids)

# 2.2 Map into Bags-of-Words
corpus = [dictionary.doc2bow(p) for p in paragraphs]


# 3.1 Build TF-IDF model
tfidf_model = gensim.models.TfidfModel(corpus)

# 3.2 BOW to TF-IDF weights
tfidf_corpus = tfidf_model[corpus]

# 3.3 Create MatrixSimilarity object
import warnings
warnings.simplefilter(action='ignore', category=FutureWarning)
tfidf_index = gensim.similarities.MatrixSimilarity(tfidf_corpus)

# 3.4
lsi_model = gensim.models.LsiModel(tfidf_corpus, id2word=dictionary, num_topics=100)
lsi_corpus = lsi_model[corpus]
lsi_index = gensim.similarities.MatrixSimilarity(lsi_corpus)

# 3.5
result = lsi_model.show_topics()
''' Output:
[
    (0, '0.147*"labour" + 0.137*"price" + 0.128*"employ" + 0.128*"produc" + 0.122*"capit" + 0.122*"countri" + 0.119*"trade" + 0.119*"hi" + 0.115*"tax" + 0.113*"land"'),
    (1, '-0.260*"labour" + -0.204*"rent" + 0.202*"silver" + -0.193*"land" + 0.191*"gold" + -0.190*"stock" + -0.184*"employ" + -0.183*"profit" + -0.171*"capit" + -0.159*"wage"'),
    (2, '-0.350*"price" + -0.241*"silver" + -0.208*"quantiti" + 0.203*"trade" + -0.165*"labour" + -0.163*"gold" + 0.162*"coloni" + -0.161*"valu" + -0.137*"corn" + -0.136*"coin"')
]
#'''

# 4.1
def preprocessing(query):
    new_query = [word.strip(string.punctuation) for word in query.lower().split()]
    return [stemmer.stem(word) for word in new_query if len(word) != 0]

q1 = "How taxes influence Economics?"
q2 = "What is the function of money?"

query = preprocessing(q2)
query = dictionary.doc2bow(query)

# 4.2
vec_tfidf = tfidf_model[query]
'''
print({dictionary.id2token[id]: val for id, val in vec_tfidf})
# Output for q1: {'influenc': 0.5179697698995116, 'tax': 0.25918286432515253, 'econom': 0.8151880521146373}
# Output for q2: {'money': 0.3155744644337493, 'function': 0.9489008153634142}
#'''

# 4.3
query = preprocessing(q2)
query = dictionary.doc2bow(query)
vec_tfidf = tfidf_model[query]
doc2similarity = enumerate(tfidf_index[vec_tfidf])
output = sorted(doc2similarity, key=lambda kv: -kv[1])[:3]
'''
for p in output:
    print('[paragraph {}]'.format(p[0]))
    print(' ' + original_paragraphs[p[0]])
    print()
#'''
'''
Output for q1: ("How taxes influence Economics?")

[paragraph 379]
 As men, like all other animals, ...
[paragraph 2003]
 Capitation Taxes.
[paragraph 2013]
 The impossibility of taxing the ...

Output for q2: ("What is the function of money?")

[paragraph 677]
 The general stock of any country ...
[paragraph 988]
 That wealth consists in money, ...
[paragraph 812]
 Whatever part of his stock a man ...
'''

# 4.4
lsi_query = lsi_model[query]
sorted_lsi_query = sorted(lsi_query, key=lambda kv: -abs(kv[1]))[:3]
doc2similarity = enumerate(lsi_index[lsi_query])
sorted_doc2similarity = sorted(doc2similarity, key=lambda kv: -kv[1])[:3]
#'''
for topic, val in sorted_lsi_query:
    print('[topic {}]'.format(topic))
    print(' ' + lsi_model.show_topics()[topic][1])
#'''
'''
Output for q1: ("How taxes influence Economics?")

[topic 3]
0.438*"tax" + -0.207*"trade" + 0.195*"rent" + -0.170*"foreign" + -0.160*"capit" + -0.148*"employ" + -0.144*"manufactur" + 0.140*"upon" + -0.133*"quantiti" + -0.125*"labour"
[topic 5]
-0.415*"tax" + -0.226*"capit" + -0.155*"foreign" + -0.135*"consumpt" + -0.134*"duti" + -0.133*"upon" + -0.121*"trade" + 0.113*"hi" + -0.113*"export" + -0.109*"consum"
[topic 9]
-0.291*"tax" + 0.216*"bank" + -0.210*"coloni" + -0.190*"labour" + 0.189*"land" + 0.162*"manufactur" + -0.162*"wage" + 0.161*"rent" + 0.146*"cultiv" + 0.145*"corn"

Output for q2: ("What is the function of money?")

[topic 4]
 -0.259*"bank" + 0.240*"price" + -0.229*"circul" + -0.217*"capit" + -0.194*"gold" + -0.185*"money" + 0.166*"corn" + 0.154*"tax" + -0.143*"coin" + -0.139*"silver"
[topic 16]
 0.313*"coloni" + 0.274*"circul" + 0.174*"price" + -0.173*"increas" + 0.158*"money" + -0.152*"cent" + -0.150*"coin" + -0.149*"per" + -0.143*"trade" + 0.135*"paper"
[topic 12]
 -0.373*"bank" + 0.199*"coin" + 0.179*"profit" + 0.174*"silver" + -0.158*"money" + 0.155*"gold" + -0.152*"tax" + -0.151*"commod" + 0.146*"stock" + 0.138*"hi"
'''
