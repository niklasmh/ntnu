__author__ = 'Niklas'
# -*- coding: utf-8 -*-

# import re

videoer = ['https://www.youtube.com/watch?v=dQw4w9WgXcQ',
           'https://www.youtube.com/watch?v=cpPG0bKHYKc',
           'https://www.youtube.com/watch?v=hFhiV5X5QM4',
           'https://www.youtube.com/watch?v=6r1DFGpBzrc',
           'https://www.youtube.com/watch?v=Ow3CcOGNIss',
           'https://www.youtube.com/watch?v=z9Uz1icjwrM']

vids = []

for i in videoer:
    # vids.append("youtu.be/"
    # + re.search(r'.{11}$', i).group())
    vids.append("youtu.be/" + i[31:])

print(vids)
