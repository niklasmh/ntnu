#!/usr/bin/python3

def perceptron(expectedIO, times=100):
  from random import random

  def step(val):
    return 1 if val >= 0 else 0

  # Init
  weightCount = len(expectedIO[0][0])
  weights = [random() - .5 for i in range(weightCount)]
  threshold = random() - .5
  learning_rate = 0.1
  epoch = 0
  matches = 0
  print("Initial weights {}".format(weights))
  print("Threshold {}".format(threshold))

  # Train
  for i in range(times):
    if not i % len(expectedIO):
      epoch += 1
      print("Epoch {}".format(epoch))
    if matches >= len(expectedIO):
      print("Finished at epoch {}!\n".format(epoch))
      break
    x, expected = expectedIO[i % len(expectedIO)]
    actual = step(sum([x[j] * weights[j] for j in range(len(x))]) - threshold)
    error = expected - actual
    prevWeights = weights
    if error == 0:
      matches += 1
    else:
      matches = 0
    weights = [learning_rate * error * x[j] + weights[j] for j in range(len(x))]
    print("Inputs: {} => Output: {}, Initial weights: {}, Result: {}, Error: {}, Final weights: {}".format(
      x,
      expected,
      ddt(prevWeights),
      actual,
      error,
      ddt(weights))
    )

  # Result
  print("Final results:")
  for x, _ in expectedIO:
    result = sum([x[j] * weights[j] for j in range(len(x))])
    print("{}: {} => {}".format(x[:2], dd(result), step(result - threshold)))
  print("\n")

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

# The perceptron does not manage negation if the threshold has a positive value
#perceptron([
#  ([0], 1),
#  ([1], 0)
#])

'''
Oppgave B:

Vektene endrer seg ut ifra hvilken startverdi som både vektene og threshold har til å starte med.
Får man iterert nok ganger, vil man finne vektene som trengs for å finne resultatet av AND og OR operatorene.

Output:

Initial weights [-0.44262521907278585, -0.410286078571349]
Threshold 0.2
Epoch 1
Inputs: [0, 0] => Output: 0, Initial weights: [-0.44, -0.41], Result: 0, Error: 0, Final weights: [-0.44, -0.41]
Inputs: [0, 1] => Output: 0, Initial weights: [-0.44, -0.41], Result: 0, Error: 0, Final weights: [-0.44, -0.41]
Inputs: [1, 0] => Output: 0, Initial weights: [-0.44, -0.41], Result: 0, Error: 0, Final weights: [-0.44, -0.41]
Inputs: [1, 1] => Output: 1, Initial weights: [-0.44, -0.41], Result: 0, Error: 1, Final weights: [-0.34, -0.31]
Epoch 2
Inputs: [0, 0] => Output: 0, Initial weights: [-0.34, -0.31], Result: 0, Error: 0, Final weights: [-0.34, -0.31]
Inputs: [0, 1] => Output: 0, Initial weights: [-0.34, -0.31], Result: 0, Error: 0, Final weights: [-0.34, -0.31]
Inputs: [1, 0] => Output: 0, Initial weights: [-0.34, -0.31], Result: 0, Error: 0, Final weights: [-0.34, -0.31]
Inputs: [1, 1] => Output: 1, Initial weights: [-0.34, -0.31], Result: 0, Error: 1, Final weights: [-0.24, -0.21]
Epoch 3
Inputs: [0, 0] => Output: 0, Initial weights: [-0.24, -0.21], Result: 0, Error: 0, Final weights: [-0.24, -0.21]
Inputs: [0, 1] => Output: 0, Initial weights: [-0.24, -0.21], Result: 0, Error: 0, Final weights: [-0.24, -0.21]
Inputs: [1, 0] => Output: 0, Initial weights: [-0.24, -0.21], Result: 0, Error: 0, Final weights: [-0.24, -0.21]
Inputs: [1, 1] => Output: 1, Initial weights: [-0.24, -0.21], Result: 0, Error: 1, Final weights: [-0.14, -0.11]
Epoch 4
Inputs: [0, 0] => Output: 0, Initial weights: [-0.14, -0.11], Result: 0, Error: 0, Final weights: [-0.14, -0.11]
Inputs: [0, 1] => Output: 0, Initial weights: [-0.14, -0.11], Result: 0, Error: 0, Final weights: [-0.14, -0.11]
Inputs: [1, 0] => Output: 0, Initial weights: [-0.14, -0.11], Result: 0, Error: 0, Final weights: [-0.14, -0.11]
Inputs: [1, 1] => Output: 1, Initial weights: [-0.14, -0.11], Result: 0, Error: 1, Final weights: [-0.04, -0.01]
Epoch 5
Inputs: [0, 0] => Output: 0, Initial weights: [-0.04, -0.01], Result: 0, Error: 0, Final weights: [-0.04, -0.01]
Inputs: [0, 1] => Output: 0, Initial weights: [-0.04, -0.01], Result: 0, Error: 0, Final weights: [-0.04, -0.01]
Inputs: [1, 0] => Output: 0, Initial weights: [-0.04, -0.01], Result: 0, Error: 0, Final weights: [-0.04, -0.01]
Inputs: [1, 1] => Output: 1, Initial weights: [-0.04, -0.01], Result: 0, Error: 1, Final weights: [0.06, 0.09]
Epoch 6
Inputs: [0, 0] => Output: 0, Initial weights: [0.06, 0.09], Result: 0, Error: 0, Final weights: [0.06, 0.09]
Inputs: [0, 1] => Output: 0, Initial weights: [0.06, 0.09], Result: 0, Error: 0, Final weights: [0.06, 0.09]
Inputs: [1, 0] => Output: 0, Initial weights: [0.06, 0.09], Result: 0, Error: 0, Final weights: [0.06, 0.09]
Inputs: [1, 1] => Output: 1, Initial weights: [0.06, 0.09], Result: 0, Error: 1, Final weights: [0.16, 0.19]
Epoch 7
Inputs: [0, 0] => Output: 0, Initial weights: [0.16, 0.19], Result: 0, Error: 0, Final weights: [0.16, 0.19]
Inputs: [0, 1] => Output: 0, Initial weights: [0.16, 0.19], Result: 0, Error: 0, Final weights: [0.16, 0.19]
Inputs: [1, 0] => Output: 0, Initial weights: [0.16, 0.19], Result: 0, Error: 0, Final weights: [0.16, 0.19]
Inputs: [1, 1] => Output: 1, Initial weights: [0.16, 0.19], Result: 1, Error: 0, Final weights: [0.16, 0.19]
Epoch 8
Finished at epoch 8!

Final results:
[0, 0]: 0.0 => 0
[0, 1]: 0.19 => 0
[1, 0]: 0.16 => 0
[1, 1]: 0.35 => 1


Initial weights [-0.051105144015371584, 0.3584145398373678]
Threshold 0.2
Epoch 1
Inputs: [0, 0] => Output: 0, Initial weights: [-0.05, 0.36], Result: 0, Error: 0, Final weights: [-0.05, 0.36]
Inputs: [0, 1] => Output: 1, Initial weights: [-0.05, 0.36], Result: 1, Error: 0, Final weights: [-0.05, 0.36]
Inputs: [1, 0] => Output: 1, Initial weights: [-0.05, 0.36], Result: 0, Error: 1, Final weights: [0.05, 0.36]
Inputs: [1, 1] => Output: 1, Initial weights: [0.05, 0.36], Result: 1, Error: 0, Final weights: [0.05, 0.36]
Epoch 2
Inputs: [0, 0] => Output: 0, Initial weights: [0.05, 0.36], Result: 0, Error: 0, Final weights: [0.05, 0.36]
Inputs: [0, 1] => Output: 1, Initial weights: [0.05, 0.36], Result: 1, Error: 0, Final weights: [0.05, 0.36]
Inputs: [1, 0] => Output: 1, Initial weights: [0.05, 0.36], Result: 0, Error: 1, Final weights: [0.15, 0.36]
Inputs: [1, 1] => Output: 1, Initial weights: [0.15, 0.36], Result: 1, Error: 0, Final weights: [0.15, 0.36]
Epoch 3
Inputs: [0, 0] => Output: 0, Initial weights: [0.15, 0.36], Result: 0, Error: 0, Final weights: [0.15, 0.36]
Inputs: [0, 1] => Output: 1, Initial weights: [0.15, 0.36], Result: 1, Error: 0, Final weights: [0.15, 0.36]
Inputs: [1, 0] => Output: 1, Initial weights: [0.15, 0.36], Result: 0, Error: 1, Final weights: [0.25, 0.36]
Inputs: [1, 1] => Output: 1, Initial weights: [0.25, 0.36], Result: 1, Error: 0, Final weights: [0.25, 0.36]
Epoch 4
Inputs: [0, 0] => Output: 0, Initial weights: [0.25, 0.36], Result: 0, Error: 0, Final weights: [0.25, 0.36]
Inputs: [0, 1] => Output: 1, Initial weights: [0.25, 0.36], Result: 1, Error: 0, Final weights: [0.25, 0.36]
Inputs: [1, 0] => Output: 1, Initial weights: [0.25, 0.36], Result: 1, Error: 0, Final weights: [0.25, 0.36]
Finished at epoch 4!

Final results:
[0, 0]: 0.0 => 0
[0, 1]: 0.36 => 1
[1, 0]: 0.25 => 1
[1, 1]: 0.61 => 1
'''