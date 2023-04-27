package main

import (
	"fmt"
	"math"
	"time"
)

func main() {
	var A, B, i, j float64
	var k int
	z := make([]float64, 1760)
	b := make([]string, 1760)

	for {
		clearScreen()

		for j = 0; j < 6.28; j += 0.07 {
			for i = 0; i < 6.28; i += 0.02 {
				c := math.Sin(i)
				d := math.Cos(j)
				e := math.Sin(A)
				f := math.Sin(j)
				g := math.Cos(A)
				h := d + 2
				D := 1 / (c*h*e + f*g + 5)
				l := math.Cos(i)
				m := math.Cos(B)
				n := math.Sin(B)
				t := c*h*g - f*e
				x := int(40 + 30*D*(l*h*m-t*n))
				y := int(12 + 15*D*(l*h*n+t*m))
				o := x + 80*y
				N := int(8 * ((f*e-c*d*g)*m - c*d*e - f*g - l*d*n))

				if y >= 0 && y < 22 && x >= 0 && x < 80 && D > z[o] {
					z[o] = D
					b[o] = string(".,-~:;=!*#$@"[ensureIndex(N, len(".,-~:;=!*#$@"))])
				}
			}
		}

		fmt.Print("\x1b[H")
		for k = 0; k < 1760; k++ {
			fmt.Print(b[k])
			b[k] = " "
			z[k] = 0
			if (k+1)%80 == 0 {
				fmt.Print("\n")
			}
		}

		A += 0.07
		B += 0.03
		time.Sleep(50 * time.Millisecond)
	}
}

func clearScreen() {
	fmt.Print("\x1b[2J")
}

func ensureIndex(index int, length int) int {
	var res int

	if index >= 0 && index < length {
		res = index
	} else if index == length {
		res = length - 1
	} else if index <= 0 {
		res = 0
	}

	return res
}
