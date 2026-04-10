import Link from "next/link";

const privacyPoints = [
  {
    icon: "🚫",
    title: "No account required",
    description: "Start using Jean immediately — no signup, no login, no email.",
  },
  {
    icon: "📊",
    title: "No analytics or tracking",
    description:
      "Zero tracking, zero analytics, zero crash reporting. We don't know who you are.",
  },
  {
    icon: "🔐",
    title: "Secure key storage",
    description:
      "API keys stored in iOS Keychain and Android Keystore with hardware-backed encryption.",
  },
  {
    icon: "💾",
    title: "Everything stored locally",
    description:
      "All conversations, agents, and settings live on your device. Nowhere else.",
  },
];

  // {
  //   icon: "🗑️",
  //   title: "Delete anytime",
  //   description:
  //     "Delete your data in the app, or uninstall to remove everything instantly.",
  // },


export default function PrivacySection() {
  return (
    <section id="privacy" className="py-24 px-6 bg-muted/90">
      <div className="mx-auto max-w-6xl text-center">
        <h2 className="text-3xl sm:text-4xl font-bold mb-4">
          Your data. Your device. Period.
        </h2>
        <p className="text-muted-foreground mb-16 max-w-2xl mx-auto">
          Jean is designed with privacy at its core. We don&apos;t operate
          servers that collect, store, or process your personal data.
        </p>

        <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-6 mb-12">
          {privacyPoints.map((point) => (
            <div
              key={point.title}
              className="rounded-2xl border border-border bg-card p-6 text-left"
            >
              <span className="text-2xl mb-3 block">{point.icon}</span>
              <h3 className="text-base font-semibold mb-2">{point.title}</h3>
              <p className="text-sm text-muted-foreground">
                {point.description}
              </p>
            </div>
          ))}
        </div>

        {/* Data flow diagram */}
        <div className="inline-flex items-center gap-4 rounded-xl border border-border bg-card px-8 py-4 text-sm text-muted-foreground">
          <span className="font-medium text-foreground">📱 Your Device</span>
          <span className="text-accent">→</span>
          <span className="font-medium text-foreground">🤖 AI Provider</span>
          <span className="text-muted-foreground ml-2">
            (direct connection, no intermediary)
          </span>
        </div>

        <div className="mt-8">
          <Link
            href="/privacy"
            className="text-sm text-accent hover:underline"
          >
            Read our full Privacy Policy →
          </Link>
        </div>
      </div>
    </section>
  );
}
