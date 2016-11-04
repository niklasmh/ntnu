.thumb
.syntax unified

.include "gpio_constants.s"     // Register-adresser og konstanter for GPIO

.text
	.global Start
	
Start:
	ldr r0, =GPIO_BASE + (PORT_SIZE * LED_PORT)
	ldr r1, =GPIO_PORT_DOUTCLR
	add r1, r0, r1
	ldr r2, =GPIO_PORT_DOUTSET
	add r0, r0, r2

	ldr r2, =GPIO_BASE + (PORT_SIZE * BUTTON_PORT) + GPIO_PORT_DIN

	ldr r3, =1 << LED_PIN
	ldr r4, =1 << BUTTON_PIN

Loop:
	ldr r6, [r2]
	and r6, r6, r4
	cmp r6, r4
	beq TurnOn
TurnOff:
	str r3, [r0]
	B Loop
TurnOn:
	str r3, [r1]
	B Loop

NOP // Behold denne på bunnen av fila
