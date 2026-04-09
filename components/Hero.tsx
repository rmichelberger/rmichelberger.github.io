import Image from "next/image";

export default function Hero() {
  return (
    <section className="relative min-h-screen flex items-center justify-center pt-20 pb-16 px-6 overflow-hidden">
      {/* Background gradient */}
      <div className="absolute inset-0 bg-gradient-to-b from-accent/5 via-transparent to-transparent pointer-events-none" />

      <div className="mx-auto max-w-6xl w-full grid grid-cols-1 lg:grid-cols-2 gap-12 items-center">
        {/* Text content */}
        <div className="relative z-10">
          <h1 className="text-4xl sm:text-5xl lg:text-6xl font-bold tracking-tight leading-tight">
            Stop chatting. {" "}
            <span className="text-accent">Start doing.</span>
          </h1>
          <p className="mt-6 text-lg sm:text-xl text-muted-foreground leading-relaxed max-w-xl">
            Jean is a privacy-first AI assistant for iOS and Android. It doesn't just talk, it get things done. Use tools. Build custom agents. All data stays on your
            device. Bring your own API keys.
          </p>
          <div className="mt-8 flex flex-wrap gap-4">
            <a
              href="#beta"
              className="rounded-full bg-accent px-8 py-3 text-base font-medium text-accent-foreground hover:bg-accent/90 transition-colors"
            >
              Join the Beta
            </a>
            <a
              href="#features"
              className="rounded-full border border-border px-8 py-3 text-base font-medium text-foreground hover:bg-muted transition-colors"
            >
              Learn More
            </a>
          </div>
        </div>

        {/* App screenshot placeholder */}
        <div className="relative z-10 flex justify-center lg:justify-end">
          <div className="relative w-[280px] sm:w-[320px]">
            {/* Phone frame */}
            <div className="rounded-[2.5rem] border-4 border-border bg-card p-2 shadow-2xl">
              <div className="rounded-[2rem] overflow-hidden bg-muted aspect-[9/19.5] flex items-center justify-center">
                {/* Screenshot placeholder - replace with actual screenshot */}
                <div className="text-center p-8">
                  <Image
                    src="/images/app-icon.png"
                    alt="Jean app icon"
                    width={80}
                    height={80}
                    className="mx-auto rounded-2xl mb-4"
                  />
                  <p className="text-sm text-muted-foreground">
                    Personal assistant
                    <br />
                    in your pocket.
                  </p>
                </div>
              </div>
            </div>
            {/* Glow effect */}
            <div className="absolute -inset-4 bg-accent/10 blur-3xl rounded-full -z-10" />
          </div>
        </div>
      </div>
    </section>
  );
}
