#!/usr/bin/python3

GRAVITY = 9.81

# a)
def get_fall_time(meter):
    return (2*meter/GRAVITY)**.5

dist = 20
print('Antallet meter objektet skal ramle:', 20)
solution = get_fall_time(dist)
print('Det tar', solution, 'sekunder å ramle', dist, 'meter')

# b)
def set_gravity(gravity):
    global GRAVITY
    GRAVITY = gravity

def new_get_fall_time(meter, gravity=GRAVITY):
    return (2*meter/gravity)**.5

set_gravity(9.67)

print(new_get_fall_time(20))
print(new_get_fall_time(20, 1.62))
