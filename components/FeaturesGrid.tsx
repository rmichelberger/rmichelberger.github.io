const features = [
  {
    icon: "🔑",
    title: "Multi-Provider AI",
    description:
      "Choose between Gemini, OpenAI, and Anthropic. Use your own API keys — switch models anytime.",
  },
  {
    icon: "🛠️",
    title: "Built-in Tools",
    description:
      "Email, calendar, camera, files, location, web requests — your AI can take real actions on your phone.",
  },
  {
    icon: "⚡",
    title: "Background Tasks",
    description:
      "Agents work for you even when you are not looking. Schedule tasks and let them run.",
  },
  {
    icon: "🔒",
    title: "Privacy First",
    description:
      "No account. No tracking. No data collection. Everything stays on your device.",
  },
];

  // {
  //   icon: "📁",
  //   title: "File Explorer",
  //   description:
  //     "Browse, create, and manage files directly through your AI assistant.",
  // },

  //   {
  //   icon: "🤖",
  //   title: "Custom Agents",
  //   description:
  //     "Build specialized assistants with custom prompts, pinned models, and selected tools.",
  // },



export default function FeaturesGrid() {
  return (
    <section id="features" className="py-24 px-6">
      <div className="mx-auto max-w-6xl">
        <h2 className="text-3xl sm:text-4xl font-bold text-center mb-4">
          Everything you need in an AI assistant
        </h2>
        <p className="text-center text-muted-foreground mb-16 max-w-2xl mx-auto">
          Powerful features that make Jean your most capable mobile AI companion.
        </p>

        <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-2 gap-6">
          {features.map((feature) => (
            <div
              key={feature.title}
              className="rounded-2xl border border-border bg-card p-6 hover:border-accent/50 transition-colors"
            >
              <span className="text-3xl mb-4 block">{feature.icon}</span>
              <h3 className="text-lg font-semibold mb-2">{feature.title}</h3>
              <p className="text-sm text-muted-foreground leading-relaxed">
                {feature.description}
              </p>
            </div>
          ))}
        </div>
      </div>
    </section>
  );
}
