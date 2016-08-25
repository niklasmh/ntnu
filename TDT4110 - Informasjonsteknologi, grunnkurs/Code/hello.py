i = 1
n = 13195
f = [5]

while i < n:
        i += 1
        x = n%i
        
        if x == 0:
                j = 0
                
                while j < len(f):
                        
                        if x%f[j] == 0:
                                f.append(i)
                        j += 1

#print(i, 'is a prime factor of', n)
print(f)

print('done!')
