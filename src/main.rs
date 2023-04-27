use std::f32::consts::PI;

const WIDTH: usize = 40;
const HEIGHT: usize = 15;

fn main() {
    let mut t: f32 = 0.0;

    loop {
        for j in 0..HEIGHT {
            for i in 0..WIDTH {
                let x = (i as f32 - WIDTH as f32 / 2.0) / (HEIGHT as f32 / 2.0);
                let y = (j as f32 - HEIGHT as f32 / 2.0) / (HEIGHT as f32 / 2.0);
                let r1 = x.powi(2) + y.powi(2);
                let r2 = (x - 0.25 * (2.0 * PI * t).cos()).powi(2)
                    + (y - 0.25 * (2.0 * PI * t).sin()).powi(2);
                let k = (r1 - 0.75 * r2).cos();

                let ch = if k > 0.0 { ' ' } else { '#' };

                print!("{}", ch);
            }
            println!();
        }

        std::thread::sleep(std::time::Duration::from_millis(50));

        t += 0.02;

        print!("\x1B[{}A", HEIGHT + 1);
    }
}
