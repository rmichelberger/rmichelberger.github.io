export default function BetaTestingSection() {
  return (
    <section id="beta" className="py-24 px-6 bg-muted/30">
      <div className="mx-auto max-w-3xl text-center">
        <h2 className="text-3xl sm:text-4xl font-bold mb-6">
          Be among the first to try Jean
        </h2>
        <p className="text-lg text-muted-foreground mb-10 max-w-xl mx-auto">
          Jean is in beta. Join our TestFlight program and help shape the future
          of your AI assistant.
        </p>

        <a
          href="https://testflight.apple.com/join/g3H6G4Qt"
          target="_blank"
          rel="noopener noreferrer"
          className="inline-flex items-center gap-3 rounded-full bg-accent px-10 py-4 text-lg font-medium text-accent-foreground hover:bg-accent/90 transition-colors"
        >
          <svg
            className="w-6 h-6"
            fill="currentColor"
            viewBox="0 0 24 24"
            aria-hidden="true"
          >
            <path d="M18.71 19.5c-.83 1.24-1.71 2.45-3.05 2.47-1.34.03-1.77-.79-3.29-.79-1.53 0-2 .77-3.27.82-1.31.05-2.3-1.32-3.14-2.53C4.25 17 2.94 12.45 4.7 9.39c.87-1.52 2.43-2.48 4.12-2.51 1.28-.02 2.5.87 3.29.87.78 0 2.26-1.07 3.8-.91.65.03 2.47.26 3.64 1.98-.09.06-2.17 1.28-2.15 3.81.03 3.02 2.65 4.03 2.68 4.04-.03.07-.42 1.44-1.38 2.83M13 3.5c.73-.83 1.94-1.46 2.94-1.5.13 1.17-.34 2.35-1.04 3.19-.69.85-1.83 1.51-2.95 1.42-.15-1.15.41-2.35 1.05-3.11z" />
          </svg>
          Join the Beta on TestFlight
        </a>

        <p className="mt-6 text-sm text-muted-foreground">
          Currently available for iOS via TestFlight. Android coming soon.
        </p>
      </div>
    </section>
  );
}
