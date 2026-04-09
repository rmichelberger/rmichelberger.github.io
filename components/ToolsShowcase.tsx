const tools = [
  {
    icon: "🤖",
    name: "Agent Manager",
    description: "Create and manage AI agents on the fly",
  },
  {
    icon: "📷",
    name: "Camera",
    description: "Capture photos for AI-assisted analysis",
  },
  {
    icon: "📅",
    name: "Calendar",
    description: "Schedule events hands-free",
  },
  {
    icon: "✉️",
    name: "Email",
    description: "Compose and send emails through conversation",
  },
  {
    icon: "📂",
    name: "File Explorer",
    description: "Browse, read, and write files",
  },
  {
    icon: "🌐",
    name: "HTTP Client",
    description: "Make web requests and fetch data",
  },
  {
    icon: "📍",
    name: "Location",
    description: "Location-aware responses",
  },
  {
    icon: "🎥",
    name: "Video Recording",
    description: "Record video for AI tasks",
  },
  {
    icon: "✅",
    name: "Task Manager",
    description: "Create and track background tasks",
  },
];

export default function ToolsShowcase() {
  return (
    <section id="tools" className="py-24 px-6 bg-muted/30">
      <div className="mx-auto max-w-6xl">
        <h2 className="text-3xl sm:text-4xl font-bold text-center mb-4">
          AI that takes action
        </h2>
        <p className="text-center text-muted-foreground mb-16 max-w-2xl mx-auto">
          Built-in tools that let your AI assistant interact with the real
          world — right from your phone.
           <br />
          And more to come...
        </p>

        <div className="grid grid-cols-2 sm:grid-cols-3 gap-4">
          {tools.map((tool) => (
            <div
              key={tool.name}
              className="rounded-xl border border-border bg-card p-5 text-center hover:border-accent/50 transition-colors"
            >
              <span className="text-2xl mb-3 block">{tool.icon}</span>
              <h3 className="text-sm font-semibold mb-1">{tool.name}</h3>
              <p className="text-xs text-muted-foreground">
                {tool.description}
              </p>
            </div>
          ))}
        </div>
      </div>
    </section>
  );
}
