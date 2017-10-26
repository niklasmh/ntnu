#!/usr/bin/python3

def perceptron(expectedIO, times=100):
  from random import random

  def step(val):
    return 1 if val >= 0 else 0

  # Init
  weightCount = len(expectedIO[0][0])
  weights = [random() - .5 for i in range(weightCount)]
  threshold = .2#random() - .5
  learning_rate = 0.1
  epoch = 0
  matches = 0
  #print(weights)

  # Train
  for i in range(times):
    if not i % len(expectedIO):
      epoch += 1
      if matches == len(expectedIO):
        print("Finished at epoch " + str(epoch))
        break
      #print("Epoch " + str(epoch))
    x, expected = expectedIO[i % len(expectedIO)]
    actual = step(sum([x[j] * weights[j] for j in range(len(x))]) - threshold)
    error = expected - actual
    prevWeights = weights
    if prevWeights == weights:
      matches += 1
    else:
      matches = 0
    weights = [learning_rate * error * x[j] + weights[j] for j in range(len(x))]
    #print((x, expected, ddt(prevWeights), actual, error, ddt(weights)))

  # Result
  for x, _ in expectedIO:
    result = sum([x[j] * weights[j] for j in range(len(x))])
    print("{}: {} -> {}".format(x[:2], dd(result), step(result - threshold)))

def dd(n):
  return round(n * 100) / 100

def ddt(t):
  return [dd(i) for i in t]

perceptron([
  ([0, 0], 0),
  ([0, 1], 0),
  ([1, 0], 0),
  ([1, 1], 1)
])

perceptron([
  ([0, 0], 0),
  ([0, 1], 1),
  ([1, 0], 1),
  ([1, 1], 1)
])

perceptron([
  ([0], 1),
  ([1], 0)
])
