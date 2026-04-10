import Image from "next/image";

const providers = [
  {
    name: "Google",
    subtitle: "Gemini",
    logo: "/providers/gemini.png",
  },
  {
    name: "OpenAI",
    subtitle: "GPT & more",
    logo: "/providers/openai.png",
  },
  {
    name: "Anthropic",
    subtitle: "Claude",
    logo: "/providers/anthropic.png",
  },
];

export default function ProvidersSection() {
  return (
    <section  id="providers" className="py-24 px-6">
      <div className="mx-auto max-w-6xl text-center">
        <h2 className="text-3xl sm:text-4xl font-bold mb-4">
          Choose your AI, your way
        </h2>
        <p className="text-muted-foreground mb-16 max-w-2xl mx-auto">
          BYOK - Bring your own API keys. Pin a provider per agent. Switch models
          freely.
        </p>

        <div className="grid grid-cols-1 sm:grid-cols-3 gap-6 max-w-3xl mx-auto">
          {providers.map((provider) => (
            <div
              key={provider.name}
              className="rounded-2xl border border-border bg-card p-8 flex flex-col items-center hover:border-accent/50 transition-colors"
            >
              <Image
                src={provider.logo}
                alt={`${provider.name} logo`}
                width={64}
                height={64}
                className="mb-4 rounded-l"
                style={{ width: "auto", height: "auto" }}
              />
              <h3 className="text-lg font-semibold">{provider.name}</h3>
              <p className="text-sm text-muted-foreground">
                {provider.subtitle}
              </p>
            </div>
          ))}
        </div>
      </div>
    </section>
  );
}
