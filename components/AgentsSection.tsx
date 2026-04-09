export default function AgentsSection() {
  return (
    <section id="agents" className="py-24 px-6">
      <div className="mx-auto max-w-6xl grid grid-cols-1 lg:grid-cols-2 gap-16 items-center">
        {/* Text */}
        <div>
          <h2 className="text-3xl sm:text-4xl font-bold mb-6">
            Build your own AI specialists
          </h2>
          <p className="text-lg text-muted-foreground leading-relaxed mb-6">
            Create custom agents with tailored system prompts, specific LLM
            models, and hand-picked tool sets.
          </p>
          <p className="text-lg text-muted-foreground leading-relaxed mb-8">
            Need a writing coach? A coding helper? A travel planner? Build
            exactly the assistant you need.
          </p>
          <ul className="space-y-3">
            {[
              "Custom system prompts",
              "Pin any provider & model",
              "Select which tools each agent can use",
              "Configure generation settings",
            ].map((item) => (
              <li
                key={item}
                className="flex items-center gap-3 text-muted-foreground"
              >
                <span className="flex-shrink-0 w-5 h-5 rounded-full bg-accent/20 flex items-center justify-center">
                  <span className="text-accent text-xs">✓</span>
                </span>
                {item}
              </li>
            ))}
          </ul>
        </div>

        {/* Screenshot placeholder */}
        <div className="flex justify-center">
          <div className="w-full max-w-sm rounded-2xl border border-border bg-card p-8 text-center">
            <div className="aspect-[3/4] rounded-xl bg-muted flex items-center justify-center">
              <div className="text-center">
                <span className="text-4xl mb-3 block">🤖</span>
                <p className="text-sm text-muted-foreground">
                  Built-in
                  <br />
                  Agent editor
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  );
}
